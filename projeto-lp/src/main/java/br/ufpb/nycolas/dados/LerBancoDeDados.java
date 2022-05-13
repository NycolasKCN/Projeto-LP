package br.ufpb.nycolas.dados;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LerBancoDeDados {

    private Connection connect() {
        String url = "jdbc:sqlite:c:/BancoDeDados-LP/banco.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void lerAquivos() {
        // TODO
        connect();
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
