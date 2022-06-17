package br.ufpb.nycolas.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;
import br.ufpb.nycolas.exceptions.OsNaoExisteException;
import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

/**
 * Classe para persistir os dados do sistema
 * 
 * @author Nycolas Kevin
 * @version 1.0
 */
public class LoadDataArq implements Data {
    private final String CAMINHO_APARELHO = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\AparelhosDB.txt";
    private final String CAMINHO_FUNCIONARIO = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\FuncionarioDB.txt";
    private final String CAMINHO_OS = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\OrdensDeServicoDB.txt";
    private List<Aparelho> aparelhos = new ArrayList<Aparelho>();
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();

    /**
     * Inicia as listas e carrega os objetos
     * caso os objetos não existam a lista ficara vazia.
     */
    public LoadDataArq() {
        init();
        this.aparelhos = this.loadAparelhos();
        this.funcionarios = this.loadFuncionarios();
        this.ordemDeServicos = this.loadOrdemDeServicos();
    }

    /**
     * Caso os arquivos de dados não existam eles serão criados.
     * É escrito a primeira linha que da referência para os id's
     */
    private void init() {
        try {
            if (!arquivoExiste(CAMINHO_APARELHO)) {
                FileWriter arq = new FileWriter(CAMINHO_APARELHO);
                PrintWriter gravar = new PrintWriter(arq);
                gravar.println("100;vazio;vazio;vazio;");
                gravar.close();
            }
            if (!arquivoExiste(CAMINHO_FUNCIONARIO)) {
                FileWriter arq = new FileWriter(CAMINHO_FUNCIONARIO);
                PrintWriter gravar = new PrintWriter(arq);
                gravar.println("200;vazio;vazio;vazio;");
                gravar.close();
            }
            if (!arquivoExiste(CAMINHO_OS)) {
                FileWriter arq = new FileWriter(CAMINHO_OS);
                PrintWriter gravar = new PrintWriter(arq);
                gravar.println("300;vazio;vazio;100;200;");
                gravar.close();
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Carrega os dados de todos os aparelhos.
     * 
     * @return uma lista com todos os aparelhos que estão escritos no arquivo.
     */
    @Override
    public List<Aparelho> loadAparelhos() {
        if (arquivoExiste(CAMINHO_APARELHO)) {
            try {
                Scanner scan = new Scanner(new FileReader(CAMINHO_APARELHO));
                while (scan.hasNextLine()) {
                    String[] dados = scan.nextLine().split(";");
                    String id = dados[0];
                    String marca = dados[1];
                    String modelo = dados[2];
                    String proprietario = dados[3];

                    Aparelho ap = new Aparelho(id, marca, modelo, proprietario);

                    this.aparelhos.add(ap);
                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }

        return this.aparelhos;
    }

    /**
     * Carrega os dados de todos os funcionários.
     * 
     * @return uma lista com todos os funcionarios que estão escritos no arquivo.
     */
    @Override
    public List<Funcionario> loadFuncionarios() {
        if (arquivoExiste(CAMINHO_FUNCIONARIO)) {
            try {
                Scanner scan = new Scanner(new FileReader(CAMINHO_FUNCIONARIO));

                while (scan.hasNextLine()) {
                    String[] dados = scan.nextLine().split(";");
                    String id = dados[0];
                    String nome = dados[1];
                    String user = dados[2];
                    String senha = dados[3];

                    Funcionario f = new Funcionario(id, nome, user, senha);

                    this.funcionarios.add(f);
                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }
        return this.funcionarios;
    }

    /**
     * Carrega todos os dados das ordens de serviço, e atribui a elas seus
     * respectivos funcionários e aparelhos vinculados.
     * 
     * @return uma lista com todas as ordens de serviço escritas no arquivo.
     * 
     */
    @Override
    public List<OrdemDeServico> loadOrdemDeServicos() {
        if (arquivoExiste(CAMINHO_OS)) {
            try {
                Scanner scan = new Scanner(new FileReader(CAMINHO_OS));

                while (scan.hasNextLine()) {
                    String[] dados = scan.nextLine().split(";");
                    String id = dados[0];
                    String status = dados[1];
                    String descricao = dados[2];
                    String idAparelho = dados[3];
                    String idFuncionario = dados[4];
                    Aparelho ap = new Aparelho(idAparelho);
                    Funcionario f = new Funcionario(idFuncionario);

                    for (Aparelho a : this.aparelhos) {
                        if (a.getId().equalsIgnoreCase(idAparelho)) {
                            ap = a;
                            break;
                        }
                    }
                    for (Funcionario fu : this.funcionarios) {
                        if (fu.getId().equalsIgnoreCase(idFuncionario)) {
                            f = fu;
                            break;
                        }
                    }

                    OrdemDeServico os = new OrdemDeServico(id, status, descricao, ap, f);

                    this.ordemDeServicos.add(os);
                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }
        return this.ordemDeServicos;
    }

    /**
     * Salva todos os dados em seus respectivos arquivos .txt.
     * 
     * @return retorna true, caso tenha ocorrido tudo bem.
     */
    @Override
    public boolean salvarDados() {
        try {
            FileWriter arqAparelhos = new FileWriter(CAMINHO_APARELHO);
            PrintWriter gravarAparelhos = new PrintWriter(arqAparelhos);

            FileWriter arqFuncionarios = new FileWriter(CAMINHO_FUNCIONARIO);
            PrintWriter gravarFuncionarios = new PrintWriter(arqFuncionarios);

            FileWriter arqOs = new FileWriter(CAMINHO_OS);
            PrintWriter gravarOs = new PrintWriter(arqOs);

            for (Aparelho a : this.aparelhos) {
                gravarAparelhos.println(a.toString());
            }

            for (Funcionario f : this.funcionarios) {
                gravarFuncionarios.println(f.toString());
            }

            for (OrdemDeServico o : this.ordemDeServicos) {
                gravarOs.println(o.toString());
            }
            gravarAparelhos.close();
            gravarFuncionarios.close();
            gravarOs.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Adiciona um novo aparelho a lista aparelhos.
     * 
     * @param aparelho O aparelho a ser adicionado.
     * @return Retorna verdadeiro caso o aparelho tenha sido adicionado com sucesso.
     */
    @Override
    public boolean cadastrarAparelho(Aparelho aparelho) {
        this.aparelhos.add(aparelho);
        return true;
    }

    /**
     * Adiciona um novo funcionário a lista funcionarios.
     * 
     * @param funcionario O funcionario a ser adicionado.
     * @return Retorna verdadeiro caso o funcionario tenha sido adicionado com
     *         sucesso.
     */
    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        return true;
    }

    /**
     * Adiciona uma nova ordem de serviço a lista os.
     * 
     * @param os A ordem de serviço a ser adicionada.
     * @return Retorna verdadeiro caso a os tenha sido adicionada com sucesso.
     */
    @Override
    public boolean cadastrarOs(OrdemDeServico os) {
        this.ordemDeServicos.add(os);
        return true;
    }

    /**
     * Remove o aparelho da lista aparelhos.
     * 
     * @param aparelho O aparelho que será removido.
     * @return Retorna verdadeiro caso o aparelho tenha sido removido com sucesso.
     */
    @Override
    public void apagarAparelho(Aparelho aparelho) throws AparelhoNaoExisteException {
        if (aparelhoDeIdExiste(aparelho.getId())) {
            aparelhos.remove(aparelho);
            return;
        }
        throw new AparelhoNaoExisteException("Aparelho não existe.");
    }

    /**
     * Remove o funcionario da lista de funcionarios.
     * 
     * @param funcionario O funcionario que será removido.
     * @return Retorna verdadeiro caso o funcionario tenha sido removido com
     *         sucesso.
     */
    @Override
    public void apagarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
        if (funcionarioDeIdExiste(funcionario.getId())){
            funcionarios.remove(funcionario);
            return;
        }
        throw new FuncionarioNaoExisteException("Funcionário não existe");
    }

    /**
     * Remove a ordem de serviço da lista os.
     * 
     * @param ordemDeServico A ordem de serviço que será removida.
     * @return Retorna verdadeiro caso a ordem de serviço tenha sido removida com
     *         sucesso.
     */
    @Override
    public void apagarOs(OrdemDeServico ordemDeServico) throws OsNaoExisteException {
        if (osDeIdExiste(ordemDeServico.getId())){
            ordemDeServicos.remove(ordemDeServico);
            return;
        }
        throw new OsNaoExisteException("Ordem de serviço não existe.");
    }

    /**
     * Recebe um caminho de um arquivo e verifica se este arquivo existe
     * 
     * @param caminhoAquivo o caminho completo de onde o arquivo se encontra
     * @return Retorna verdadeiro caso exista e falso caso não exista
     */
    @Override
    public boolean arquivoExiste(String caminhoAquivo) {
        boolean existe = false;
        File fileAparelhos = new File(caminhoAquivo);

        if (fileAparelhos.exists() && !fileAparelhos.isDirectory()) {
            existe = true;
        }
        return existe;
    }

    /**
     * Retorna a lista aparelhos, que contêm os aparelhos salvos.
     * 
     * @return A lista aparelhos.
     */
    public List<Aparelho> getAparelhos() {
        return this.aparelhos;
    }

    /**
     * Retorna a lista funcionarios, que contêm os funcionarios salvos.
     * 
     * @return A lista funcionarios.
     */
    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    /**
     * Retorna a lista ordemDeServicos, que contêm as ordens de serviço salvas.
     * 
     * @return A lista ordemDeServicos
     */
    public List<OrdemDeServico> getOrdemDeServicos() {
        return this.ordemDeServicos;
    }

    /**
     * Verifica a existencia de um aparelho com id "x" na lista aparelhos.
     * 
     * @param id O id do aparelho a ser verificado.
     * @return Retorna verdadeiro caso o aparelho for encontrado.
     */
    public boolean aparelhoDeIdExiste(String id) {
        for (Aparelho a : this.aparelhos) {
            if (a.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica a existencia de um funcionario de id "x" na lista funcionarios.
     * 
     * @param id O id do funcionario a ser verificado.
     * @return Retorna verdaderio caso o funcionario for encontrado.
     */
    public boolean funcionarioDeIdExiste(String id) {
        for (Funcionario f : this.funcionarios) {
            if (f.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica a existencia de uma ordem de serviço de id "x" na lista
     * ordemDeServicos.
     * 
     * @param id O id da ordemDeServico a ser verificada.
     * @return Retorna verdaderio caso a ordem de serviço for encontrada
     */
    public boolean osDeIdExiste(String id) {
        for (OrdemDeServico os : this.ordemDeServicos) {
            if (os.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}