package br.ufpb.nycolas.dados;

import java.util.ArrayList;
import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.ufpb.nycolas.sistema.*;

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
     * Popula um lista de objetos Aparelho e a retorna.
     * 
     * @return uma lista com todos os aparelhos dentro do banco de dados
     */
    public ArrayList<Aparelho> populateAparelhos() {
        String query = "SELECT * FROM aparelhos";

        ArrayList<Aparelho> aparelhoArrayList = new ArrayList<Aparelho>();

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
                aparelhoArrayList.add(newAparelho);
            }

            conn.close();
            stmt.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aparelhoArrayList;
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
