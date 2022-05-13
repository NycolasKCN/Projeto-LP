package br.ufpb.nycolas.dados;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;

public class LerBancoDeDados {

    /**
     * Tenta conectar a o banco de dados. Retorna a conexão
     * 
     * @return
     */
    private Connection connect() {
        String url = "jdbc:sqlite:c:/BancoDeDados-LP/banco.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Popula um lista de objetos Aparelho, a partir do banco de dados SQL e a
     * retorna.
     * 
     * @return uma lista com todos os aparelhos dentro do banco de dados
     */
    public List<Aparelho> populateAparelhos() {
        String query = "SELECT rowid, marca, modelo, descricao FROM aparelhos";

        List<Aparelho> aparelhosList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = this.connect();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("rowid");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String descricao = result.getString("descricao");

                Aparelho newAparelho = new Aparelho(id, marca, modelo, descricao);
                aparelhosList.add(newAparelho);
            }

            conn.close();
            stmt.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aparelhosList;
    }

    /**
     * Popula um lista de objetos Funcionario, a partir do banco de dados SQL, e a
     * retorna.
     * 
     * @return uma lista com todos os Funcionario dentro do banco de dados
     */
    public List<Funcionario> populateFuncionarios() {
        String query = "SELECT rowid, nome, usuario, senha FROM funcionarios";

        List<Funcionario> funcionariosList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = this.connect();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("rowid");
                String nome = result.getString("nome");
                String usuario = result.getString("usuario");
                String senha = result.getString("senha");

                Funcionario newFuncionario = new Funcionario(id, nome, usuario, senha);

                funcionariosList.add(newFuncionario);
            }

            conn.close();
            stmt.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return funcionariosList;
    }

    /**
     * Recebe um caminho de um arquivo e verifica se este arquivo existe
     * 
     * @param caminhoAquivo o caminho completo de onde o arquivo se encontra
     * @return Retorna verdadeiro caso exista e falso caso não exista
     */
    public boolean arquivoExiste(String caminhoAquivo) {
        boolean existe = false;
        File fileAparelhos = new File(caminhoAquivo);

        if (fileAparelhos.exists() && !fileAparelhos.isDirectory()) {
            existe = true;
        }
        return existe;
    }
}
