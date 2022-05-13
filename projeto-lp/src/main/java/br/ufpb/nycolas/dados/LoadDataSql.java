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
import br.ufpb.nycolas.sistema.OrdemDeServico;

public class LoadDataSql implements Data {
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

    public void creatTable(String tableName) {

    }

    /**
     * Carrega os dados de aparelhos
     * 
     * @return uma lista com todos os aparelhos dentro do banco de dados
     */
    @Override
    public List<Aparelho> loadAparelhos() {
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
     * Carrega os dados de funcionarios
     * 
     * @return uma lista com todos os Funcionario dentro do banco de dados
     */
    @Override
    public List<Funcionario> loadFuncionarios() {
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
     * Carrega as ordens de serviço
     * 
     * @return uma lista com todos as OS dentro do banco de dados
     */
    @Override
    public List<OrdemDeServico> loadOrdemDeServicos() {
        String query = "SELECT rowid, nome, usuario, senha FROM funcionarios";

        List<OrdemDeServico> osList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = this.connect();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("rowid");
                String status = result.getString("status");
                String desc = result.getString("descricao");

                OrdemDeServico newOs = new OrdemDeServico(id, status, desc);

                osList.add(newOs);
            }

            conn.close();
            stmt.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return osList;
    }

    @Override
    public boolean cadastrarAparelho() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cadastrarFuncionario() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cadastrarOs() {
        // TODO Auto-generated method stub
        return false;

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
