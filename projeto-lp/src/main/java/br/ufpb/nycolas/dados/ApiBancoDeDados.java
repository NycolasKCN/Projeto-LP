package br.ufpb.nycolas.dados;

import java.util.ArrayList;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

public class ApiBancoDeDados {

    // private ArrayList<OrdemDeServico> ordensDeServico;
    // sprivate ArrayList<Funcionario> funcionarios;
    private ArrayList<Aparelho> aparelhos;

    /**
     * 
     */
    public ApiBancoDeDados() {
        LerBancoDeDados init = new LerBancoDeDados();
        this.aparelhos = init.populateAparelhos();
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

    /**
     * Registra uma nova ordem de serviço no banco de dados
     * 
     * @param novaOs uma nova ordem de serviço a ser cadatrada no banco de dados
     */
    public void registrarNovaOS(OrdemDeServico novaOs) {
        // TODO
    }

    /**
     * Registra um novo funcionario no banco de dados
     * 
     * @param novoFuncionario um novo funcionario a ser cadastrado no banco de dados
     */
    public void registrarNovoFuncionario(Funcionario novoFuncionario) {
        // TODO
    }
}