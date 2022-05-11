package br.ufpb.nycolas.db;

import br.ufpb.nycolas.sistema.*;
import java.util.ArrayList;
// import java.io.Reader;
// import java.nio.file.Files;
// import java.nio.file.Paths;

public class ApiBancoDeDados {

    private ArrayList<OrdemDeServico> ordensDeServico;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Aparelho> aparelhos;


    /**
     * 
     */
    public ApiBancoDeDados() {
    }

    /**
     * Consulta aparelhos pelo modelo, caso exista, retorna o aparelho
     * caso não exista, retorna null
     * 
     * @param modeloDoAparelho modelo do aparelho a ser consulado
     * @return retona o aparelho caso exista, e null caso não exista
     */
    public Aparelho consultarAparelhoPorModelo(String modeloDoAparelho) {
        for (Aparelho i : this.aparelhos) {
            if (i.getModelo().equals(modeloDoAparelho)) {
                return i;
            }
        }
        return null;
    }

    public void cadastrarNovoAparelho() {
        // TODO implement here
    }

    public ArrayList<Aparelho> consultarTodosAparelhos() {
        // TODO implement here
        return null;
    }

    public void registrarNovaOS() {
        // TODO implement here
    }

    public void registrarNovoFuncionario() {
        // TODO implement here
    }
}