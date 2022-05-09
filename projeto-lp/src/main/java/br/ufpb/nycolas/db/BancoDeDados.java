package br.ufpb.nycolas.db;

import br.ufpb.nycolas.sistema.*;
import java.util.ArrayList;

public class BancoDeDados {

    private ArrayList<OrdemDeServico> ordensDeServico;
    private ArrayList<Funcionario> funcionarios;
    private String caminhoArquivo;

    /**
     * 
     */
    public BancoDeDados() {
        if (this.arquivoExiste()) {
            this.lerAquivo();
        } else {
            this.criarNovoArquivo();
        }
    }

    public void consultarAparelhoPorNome() {
        // TODO implement here
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

    private void lerAquivo() {
        // TODO implement here
    }

    private boolean arquivoExiste() {
        // TODO implement here
        return false;
    }

    private void criarNovoArquivo(){
        // TODO
    }
}