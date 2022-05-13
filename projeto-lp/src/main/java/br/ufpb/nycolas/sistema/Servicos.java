package br.ufpb.nycolas.sistema;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.nycolas.dados.Data;

public class Servicos {

    // private List<OrdemDeServico> ordensDeServico;
    private List<Funcionario> funcionarios;
    private List<Aparelho> aparelhos;

    /**
     * 
     */
    public Servicos() {
        Data init = new Data();
        this.aparelhos = init.loadAparelhos();
        this.funcionarios = init.loadFuncionarios();
    }

    // ==================== Metodos Para Aparelhos =========================


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

    /**
     * Cadastra um novo aparelho no banco de dados
     * 
     * @param novoAparelho
     */
    public void cadastrarNovoAparelho(Aparelho novoAparelho) {
        // TODO
    }

    /**
     * Retorna uma ArrayList com todos os aparelhos
     * 
     * @return Retorna uma ArrayList com todos os aparelhos
     */
    public ArrayList<Aparelho> consultarTodosAparelhos() {
        // TODO
        return null;
    }

    // ==================== Metodos Para Ordens de serviço =========================


    /**
     * Registra uma nova ordem de serviço no banco de dados
     * 
     * @param novaOs uma nova ordem de serviço a ser cadatrada no banco de dados
     */
    public void registrarNovaOS(OrdemDeServico novaOs) {
        // TODO
    }

    // ==================== Metodos Para funcionarios =========================

    /**
     * Registra um novo funcionario no banco de dados
     * 
     * @param novoFuncionario um novo funcionario a ser cadastrado no banco de dados
     */
    public void registrarNovoFuncionario(Funcionario novoFuncionario) {
        // TODO
    }

    public Funcionario consultarFuncionarioPeloNome(String nomeFuncionario) {
        for (Funcionario f : this.funcionarios) {
            if (f.getNome().equals(nomeFuncionario)) {
                return f;
            }
        }
        return null;
    }
}