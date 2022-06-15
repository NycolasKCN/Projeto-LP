package br.ufpb.nycolas.sistema;

import java.util.List;

import br.ufpb.nycolas.dados.Data;
import br.ufpb.nycolas.dados.LoadDataArq;

public class Servicos {

    // TODO documentar todas as funções

    private Data data = new LoadDataArq();

    /**
     * 
     */
    public Servicos() {
    }

    /**
     * salva os dados em um arquivo .txt
     */
    public void salvar() {
        data.salvarDados();
    }

    public static <E> E getLastElement(List<E> list) {
        int lastIdx = list.size() - 1;
        E lastElement = list.get(lastIdx);
        return lastElement;
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
        Aparelho lastAp = getLastElement(data.getAparelhos());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Aparelho newAparelho = new Aparelho(idString, marca, modelo, descricao);
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

    // ==================== Metodos Para funcionarios =========================

    /**
     * Registra um novo funcionario no banco de dados
     * 
     * @param novoFuncionario um novo funcionario a ser cadastrado no banco de dados
     * @return Retorna o Funcionario que foi cadastrado
     */
    public Funcionario cadastrarNovoFuncionario(String nome, String user, String senha) {
        Funcionario lastAp = getLastElement(data.getFuncionarios());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Funcionario newFuncionario = new Funcionario(idString, nome, user, senha);
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

    // ==================== Metodos Para Ordens de serviço =========================

    /**
     * Registra uma nova ordem de serviço no banco de dados
     * 
     * @param novaOs uma nova ordem de serviço a ser cadatrada no banco de dados
     */
    public void cadastrarNovaOs(String status, String descricao, String cliente, String funcionario) {
        OrdemDeServico lastAp = getLastElement(data.getOrdemDeServicos());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        // TODO: Colocar trhows aqui e tratamento de erro
        
        OrdemDeServico os = new OrdemDeServico();
        data.cadastrarOs(os);
    }

    public void apagarOs(OrdemDeServico os) {
        data.apagarOs(os);
    }

    public List<OrdemDeServico> getOs() {
        return data.getOrdemDeServicos();
    }
}