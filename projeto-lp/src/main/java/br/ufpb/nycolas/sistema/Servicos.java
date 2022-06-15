package br.ufpb.nycolas.sistema;

import java.util.List;

import br.ufpb.nycolas.dados.Data;
import br.ufpb.nycolas.dados.LoadDataArq;

public class Servicos {

    private Data data = new LoadDataArq();

    /**
     * 
     */
    public Servicos() {
    }

    public void salvar() {
        data.salvarDados();
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
        for (Aparelho i : data.getAparelhos()) {
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
    public Aparelho cadastrarNovoAparelho(String marca, String modelo, String descricao) {
        Aparelho newAparelho = new Aparelho(marca, modelo, descricao);
        data.cadastrarAparelho(newAparelho);
        return newAparelho;
    }

    public void apagarAparelho(Aparelho ap) {
        data.apagarAparelho(ap);
    }

    /**
     * Retorna uma ArrayList com todos os aparelhos
     * 
     * @return Retorna uma ArrayList com todos os aparelhos
     */
    public List<Aparelho> getAparelhos() {
        return data.getAparelhos();
    }

    // ==================== Metodos Para Ordens de serviço =========================

    /**
     * Registra uma nova ordem de serviço no banco de dados
     * 
     * @param novaOs uma nova ordem de serviço a ser cadatrada no banco de dados
     */
    public void cadastrarNovaOs(String status, String descricao, Aparelho ap, Funcionario fu) {
        // TODO: Colocar trhows aqui e tratamento de erro
        OrdemDeServico os = new OrdemDeServico(status, descricao, ap, fu);
        data.cadastrarOs(os);
    }

    public void apagarOs(OrdemDeServico os) {
        data.apagarOs(os);
    }

    public List<OrdemDeServico> getOs() {
        return data.getOrdemDeServicos();
    }

    // ==================== Metodos Para funcionarios =========================

    /**
     * Registra um novo funcionario no banco de dados
     * 
     * @param novoFuncionario um novo funcionario a ser cadastrado no banco de dados
     * @return Retorna o Funcionario que foi cadastrado
     */
    public Funcionario cadastrarNovoFuncionario(String nome, String user, String senha) {
        Funcionario newFuncionario = new Funcionario(nome, user, senha);
        data.cadastrarFuncionario(newFuncionario);
        return newFuncionario;
    }

    public void apagarFuncionario(Funcionario f) {
        data.apagarFuncionario(f);
    }

    public Funcionario consultarFuncionarioPeloNome(String nomeFuncionario) {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getNome().equals(nomeFuncionario)) {
                return f;
            }
        }
        return null;
    }

    public List<Funcionario> getFuncionarios() {
        return data.getFuncionarios();
    }
}