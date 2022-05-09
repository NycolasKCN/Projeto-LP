package br.ufpb.nycolas.db;

import br.ufpb.nycolas.sistema.*;
import java.util.ArrayList;
// import java.io.Reader;
// import java.nio.file.Files;
// import java.nio.file.Paths;

public class BancoDeDados {

    private ArrayList<OrdemDeServico> ordensDeServico;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Aparelho> aparelhos;
    private String caminhoArquivoAparelhos = "/dados/aparelhos.csv";
    private String caminhoArquivoFuncionarios = "/dados/funcionarios.csv";
    private String caminhoArquivoOs = "/dados/ordensDeServico.csv";

    /**
     * 
     */
    public BancoDeDados() {
        if (this.arquivosExistem()) {
            this.lerAquivos();
        } else {
            this.criarNovosArquivos();
        }
    }

    public Aparelho consultarAparelhoPorModelo(String nomeDoAparelho) {
        for (Aparelho i : this.aparelhos) {
            if (i.getModelo().equals(nomeDoAparelho)){
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

    protected void lerAquivos() {
        // TODO implement here
    }

    protected boolean arquivosExistem() {
        // TODO
        boolean existe = false;
        return existe;
    }

    protected void criarNovosArquivos() {
        // TODO
    }
}