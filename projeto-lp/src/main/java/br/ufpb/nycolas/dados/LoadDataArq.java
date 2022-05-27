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

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

public class LoadDataArq implements Data {
    private String caminhoAparelho = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\AparelhosDB.txt";
    private String caminhoFuncionario = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\FuncionarioDB.txt";
    private String caminhoOs = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\OrdensDeServicoDB.txt";
    private List<Aparelho> aparelhos = new ArrayList<Aparelho>();
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();

    public LoadDataArq() {
        this.aparelhos = this.loadAparelhos();
        this.funcionarios = this.loadFuncionarios();
        this.ordemDeServicos = this.loadOrdemDeServicos();
    }

    /**
     * Carrega os dados de aparelhos
     * 
     * @return uma lista com todos os aparelhos dentro do banco de dados
     */
    @Override
    public List<Aparelho> loadAparelhos() {
        if (arquivoExiste(caminhoAparelho)) {
            try {
                Scanner scan = new Scanner(new FileReader(caminhoAparelho));

                while (scan.hasNextLine() && scan.nextLine().equals("")) {
                    String[] dados = scan.nextLine().split(";");
                    int id = Integer.parseInt(dados[0]);
                    String marca = dados[1];
                    String modelo = dados[2];
                    String descricao = dados[3];

                    Aparelho ap = new Aparelho(id, marca, modelo, descricao);

                    this.aparelhos.add(ap);
                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }

        return this.aparelhos;
    }

    @Override
    public List<Funcionario> loadFuncionarios() {
        if (arquivoExiste(caminhoFuncionario)) {
            try {
                Scanner scan = new Scanner(new FileReader(caminhoFuncionario));

                while (scan.hasNextLine() && scan.nextLine().equals("")) {
                    String[] dados = scan.nextLine().split(";");
                    int id = Integer.parseInt(dados[0]);
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

    @Override
    public List<OrdemDeServico> loadOrdemDeServicos() {
        if (arquivoExiste(caminhoOs)) {
            try {
                Scanner scan = new Scanner(new FileReader(caminhoOs));

                while (scan.hasNextLine() && scan.nextLine().equals("")) {
                    String[] dados = scan.nextLine().split(";");
                    int id = Integer.parseInt(dados[0]);
                    String status = dados[1];
                    String descricao = dados[2];
                    int idAparelho = Integer.parseInt(dados[3]);
                    int idFuncionario = Integer.parseInt(dados[4]);
                    Aparelho ap = new Aparelho(idAparelho);
                    Funcionario f = new Funcionario(idFuncionario);

                    for (Aparelho a : this.aparelhos) {
                        if (a.getId() == idAparelho) {
                            ap = a;
                            break;
                        }
                    }
                    for (Funcionario fu : this.funcionarios) {
                        if (fu.getId() == idFuncionario) {
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

    @Override
    public boolean salvarDados() {
        try {
            FileWriter arqAparelhos = new FileWriter(caminhoAparelho);
            PrintWriter gravarAparelhos = new PrintWriter(arqAparelhos);

            FileWriter arqFuncionarios = new FileWriter(caminhoFuncionario);
            PrintWriter gravarFuncionarios = new PrintWriter(arqFuncionarios);

            FileWriter arqOs = new FileWriter(caminhoOs);
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

    @Override
    public boolean cadastrarAparelho(Aparelho aparelho) {
        this.aparelhos.add(aparelho);
        return true;
    }

    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        return true;
    }

    @Override
    public boolean cadastrarOs(OrdemDeServico os) {
        this.ordemDeServicos.add(os);
        return true;
    }

    @Override
    public boolean apagarAparelho(Aparelho aparelho) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean apagarFuncionario(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean apagarOs(OrdemDeServico os) {
        // TODO Auto-generated method stub
        return false;
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

    public List<Aparelho> getAparelhos() {
        return this.aparelhos;
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public List<OrdemDeServico> getOrdemDeServicos() {
        return this.ordemDeServicos;
    }

}