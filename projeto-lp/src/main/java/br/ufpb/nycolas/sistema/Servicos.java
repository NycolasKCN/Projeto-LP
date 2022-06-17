package br.ufpb.nycolas.sistema;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.nycolas.dados.Data;
import br.ufpb.nycolas.dados.LoadDataArq;
import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;
import br.ufpb.nycolas.exceptions.OsNaoExisteException;

/**
 * Sistema para gerenciar os dados
 * 
 * @author Nycolas Kevin
 */
public class Servicos {
    private Data data;

    /**
     * Inicia o banco de dados
     */
    public Servicos() {
        this.data = new LoadDataArq();
    }

    /**
     * salva os dados em um arquivo .txt
     */
    public void salvar() {
        data.salvarDados();
    }

    /**
     * Verifica qual o ultimo elemento de uma lista e o retorna.
     * 
     * @param list
     * @return Retorna o ultimo elemento da lista
     */
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

    /**
     * Consulta nos dados os aparelhos que tem um proprietario igual ao que foi
     * passado.
     * 
     * @param nomeProp O nome do proprietario do Aparelho
     * @return Uma lista de aparelhos deste cliente
     * @throws AparelhoNaoExisteException Caso o aparelho não exista nos dados
     */
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

    /**
     * Consulta nos dados um Aparelho que tem o proprietario igual ao que foi
     * passado
     * 
     * @param nomeProp nome do proprietario
     * @return Retorna o primeiro aparelho que foi encontrado
     * @throws AparelhoNaoExisteException Caso o aparelho não exista nos dados
     */
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
     * @param marca        A marca do aparelho
     * @param modelo       Modelo do aparelho
     * @param proprietario Proprietario do aparelho e cliente
     */
    public Aparelho cadastrarNovoAparelho(String marca, String modelo, String proprietario) {
        Aparelho lastAp = getLastElement(data.getAparelhos());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Aparelho newAparelho = new Aparelho(idString, marca, modelo, proprietario);
        data.cadastrarAparelho(newAparelho);
        return newAparelho;
    }

    /**
     * Procura um aparelho com {@code Id} igual e o apaga.
     * 
     * @param id Id do aparelho para ser removido
     * @throws AparelhoNaoExisteException Caso o aparelho não exista nos dados
     */
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
     * Cadastra um novo Funcionario
     * 
     * @param nome  nome do funcionario
     * @param user  usuario
     * @param senha senha
     * @return retorna o funcionario cadastrado
     */
    public Funcionario cadastrarNovoFuncionario(String nome, String user, String senha) {
        Funcionario lastAp = getLastElement(data.getFuncionarios());
        int id = Integer.parseInt(lastAp.getId()) + 1;
        String idString = String.valueOf(id);

        Funcionario newFuncionario = new Funcionario(idString, nome, user, senha);
        data.cadastrarFuncionario(newFuncionario);
        return newFuncionario;
    }

    /**
     * Procura um funcionario pelo id
     * 
     * @param id Id para fazer a busca
     * @return Retorna o primeiro funcionario que for encontrado
     * @throws FuncionarioNaoExisteException caso o funcionario não exista ou não
     *                                       foi encontrado
     */
    public Funcionario consultarFuncionarioPorId(String id) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionario não existe ou não foi encontrado.");
    }

    /**
     * Consulta funcionarios pelo nome
     * 
     * @param nomeFuncionario nome do funcionario a ser encontrado
     * @return A lista de funcionarios que contenha o {@code nomeFuncionario}
     * @throws FuncionarioNaoExisteExceptioncaso o funcionario não exista ou não
     *                                           foi encontrado
     */
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

    /**
     * Procura um funcionario pelo nome
     * 
     * @param nomeFuncionario Id para fazer a busca
     * @return Retorna o primeiro funcionario que for encontrado
     * @throws FuncionarioNaoExisteException caso o funcionario não exista ou não
     *                                       foi encontrado
     */
    public Funcionario consultarFuncionarioPeloNome(String nomeFuncionario) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getNome().equalsIgnoreCase(nomeFuncionario)) {
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionario em questão não existe.");
    }

    /**
     * Apaga o funcionario pelo id
     * 
     * @param id id do funcionario que será removido
     * @throws FuncionarioNaoExisteException caso o funcionario não exista
     */
    public void apagarFuncionarioPorId(String id) throws FuncionarioNaoExisteException {
        for (Funcionario f : data.getFuncionarios()) {
            if (f.getId().equals(id)) {
                data.apagarFuncionario(f);
                return;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionário não pode ser apagado, pois não existe.");
    }

    /**
     * Retorna uma ArrayList com todos os Funcionarios
     * 
     * @return retorna a lista de funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return data.getFuncionarios();
    }

    // ==================== Metodos Para Ordens de serviço =========================

    /**
     * Registra uma nova ordem de serviço no banco de dados, e atribui seu
     * respectivo aparelho e funcionario
     * 
     * @param status      Progesso do aparelho
     * @param descricao   Descrição do problema
     * @param cliente     Nome do cliente e proprietario do aparelho
     * @param funcionario Nome do funcionario responsavel
     * @throws AparelhoNaoExisteException    Caso o aparelho não seja encontrado
     * @throws FuncionarioNaoExisteException Caso o funcionario não seja encontrado
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

    /**
     * Consulta e retorna as ordens de serviço de um determinado Funcionario
     * 
     * @param nomeFuncionario Funcionario responsavel pela os
     * @return Uma arrayList com todas os desse funcionario
     * @throws OsNaoExisteException caso a ordem de serviço não exista ou não seja
     *                              encontrada
     */
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

    /**
     * Consulta e retorna Ordem de serviço que tem o Id
     * 
     * @param id Id para consulta
     * @return Retorna a ordem de serviço encontrada
     * @throws OsNaoExisteException Caso a ordem de serviço não exista
     */
    public OrdemDeServico consultarOSdeId(String id) throws OsNaoExisteException {
        for (OrdemDeServico os : data.getOrdemDeServicos()) {
            if (os.getId().equals(id)) {
                return os;
            }
        }
        throw new OsNaoExisteException("Ordem de serviço não existe.");
    }

    /**
     * Procura e apaga a os de id: {@code id}
     * 
     * @param id Id da ordem de serviço que deseja apagar
     * @throws OsNaoExisteException Caso a ordem de serviço não exista
     */
    public void apagarOsPorId(String id) throws OsNaoExisteException {
        for (OrdemDeServico os : data.getOrdemDeServicos()) {
            if (os.getId().equals(id)) {
                data.apagarOs(os);
                return;
            }
        }
        throw new OsNaoExisteException("Ordem de serviço não pode ser apagada, pois não existe.");
    }

    /**
     * Retorna uma lista com todas ordens de serviço
     * 
     * @return Uma arrayList com ordens de serviço
     */
    public List<OrdemDeServico> getOs() {
        return data.getOrdemDeServicos();
    }
}