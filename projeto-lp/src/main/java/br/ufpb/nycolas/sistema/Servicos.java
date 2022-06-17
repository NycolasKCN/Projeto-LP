package br.ufpb.nycolas.sistema;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.nycolas.dados.Data;
import br.ufpb.nycolas.dados.LoadDataArq;
import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;
import br.ufpb.nycolas.exceptions.OsNaoExisteException;

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
    public Aparelho consultarAparelhoPorId(String id) throws AparelhoNaoExisteException {
        for (Aparelho i : data.getAparelhos()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        throw new AparelhoNaoExisteException("Aparelho em questão não existe.");
    }

    public List<Aparelho> consultarAparelhosPorProp(String nomeProp) throws AparelhoNaoExisteException {
        List<Aparelho> querry = new ArrayList<>();
        for (Aparelho i : data.getAparelhos()) {
            if (i.getProprietario().contains(nomeProp.toLowerCase())) {
                querry.add(i);
            }
        }
        if (!querry.isEmpty()) {
            return querry;
        } else {
            throw new AparelhoNaoExisteException("Aparelho em questão não existe.");
        }
    }

    public Aparelho consultarAparelhoPorProp(String nomeProp) throws AparelhoNaoExisteException {
        for (Aparelho i : data.getAparelhos()) {
            if (i.getProprietario().contains(nomeProp)) {
                return i;
            }
        }
        throw new AparelhoNaoExisteException("Aparelho em questão não existe.");
    }

    /**
     * Cadastra um novo aparelho no banco de dados
     * 
     * @param novoAparelho
     */
    public Aparelho cadastrarNovoAparelho(String marca, String modelo, String proprietario) {
        Aparelho lastAp = getLastElement(data.getAparelhos());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Aparelho newAparelho = new Aparelho(idString, marca, modelo, proprietario);
        data.cadastrarAparelho(newAparelho);
        return newAparelho;
    }

    public void apagarAparelhoPorId(String id) throws AparelhoNaoExisteException {
        for (Aparelho a : data.getAparelhos()) {
            if (a.getId().equals(id)) {
                data.apagarAparelho(a);
                return;
            }
        }
        throw new AparelhoNaoExisteException("Aparelho não pode ser apagado, pois não existe.");
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

    public void apagarFuncionarioPorId(String id) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getId().equals(id)) {
                data.apagarFuncionario(f);
                return;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionário não pode ser apagado, pois não existe.");
    }

    public Funcionario consultarFuncionarioPorId(String id) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionario não existe ou não foi encontrado.");
    }

    public List<Funcionario> consultarFuncionariosPeloNome(String nomeFuncionario)
            throws FuncionarioNaoExisteException {
        List<Funcionario> querry = new ArrayList<>();
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getNome().toLowerCase().contains(nomeFuncionario.toLowerCase())) {
                querry.add(f);
            }
        }

        if (!querry.isEmpty()) {
            return querry;
        } else {
            throw new FuncionarioNaoExisteException("Funcionario em questão não existe.");
        }
    }

    public Funcionario consultarFuncionarioPeloNome(String nomeFuncionario) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getNome().equalsIgnoreCase(nomeFuncionario)) {
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionario em questão não existe.");
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
    public void cadastrarNovaOs(String status, String descricao, String cliente, String funcionario)
            throws AparelhoNaoExisteException, FuncionarioNaoExisteException {

        OrdemDeServico lastAp = getLastElement(data.getOrdemDeServicos());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Aparelho ap = this.consultarAparelhoPorProp(cliente);
        Funcionario f = this.consultarFuncionarioPeloNome(funcionario);

        OrdemDeServico os = new OrdemDeServico(idString, status, descricao, ap, f);
        data.cadastrarOs(os);
    }

    public List<OrdemDeServico> consultarOSdeFuncionario(String nomeFuncionario) throws OsNaoExisteException {
        List<OrdemDeServico> querry = new ArrayList<>();
        for (OrdemDeServico os : data.getOrdemDeServicos()) {
            if (os.getFuncionarioResponsavel().getNome().toLowerCase().contains(nomeFuncionario.toLowerCase())) {
                querry.add(os);
            }
        }

        if (!querry.isEmpty()) {
            return querry;
        } else {
            throw new OsNaoExisteException("Ordem de serviço com esse funcionário não existe.");
        }
    }

    public OrdemDeServico consultarOSdeId(String id) throws OsNaoExisteException {
        for (OrdemDeServico os : data.getOrdemDeServicos()) {
            if (os.getId().equals(id)) {
                return os;
            }
        }
        throw new OsNaoExisteException("Ordem de serviço não existe.");
    }

    public void apagarOsPorId(String id) throws OsNaoExisteException {
        for (OrdemDeServico os : data.getOrdemDeServicos()) {
            if (os.getId().equals(id)) {
                data.apagarOs(os);
                return;
            }
        }
        throw new OsNaoExisteException("Ordem de serviço não pode ser apagada, pois não existe.");
    }

    public List<OrdemDeServico> getOs() {
        return data.getOrdemDeServicos();
    }
}