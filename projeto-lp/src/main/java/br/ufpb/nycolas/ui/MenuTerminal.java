package br.ufpb.nycolas.ui;

import java.io.IOException;
import java.util.Scanner;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.Servicos;

public class MenuTerminal implements Menu {

    private Scanner scan = new Scanner(System.in);
    private Servicos sistema = new Servicos();

    public MenuTerminal() {
        this.init();
    }

    public void init() {

        boolean continuar = true;

        while (continuar) {
            clean();
            System.out.println("===== Assistência técnica =====");
            System.out.println("Menu: ");
            System.out.println("1. Cadastros");
            System.out.println("2. Consultas");
            System.out.println("3. Apagar");
            System.out.println("4. Salvar");
            System.out.println("0. sair");
            System.out.print("Operação: ");
            String operacao = scan.nextLine();

            if (operacao.equals("0")) {
                continuar = false;

            } else if (operacao.equals("1")) { // Cadastros
                loopCadastros();

            } else if (operacao.equals("2")) { // Consultas 
                loopConsultas();
            } else if (operacao.equals("3")) { // Ordem de serviço

                while (true) {
                    clean();
                    System.out.println("===== Apagar =====");
                    System.out.println("1. Apagar Aparelho");
                    System.out.println("2. Apagar Funcionario");
                    System.out.println("3. Apagar Ordem de serviço");
                    System.out.println("0. Voltar");
                    System.out.print("Operação: ");
                    String operacaoCad = scan.nextLine();

                    if (operacaoCad.equals("0")) {
                        break;
                    } else if (operacaoCad.equals("1")) {

                    } else if (operacaoCad.equals("2")) {

                    } else if (operacaoCad.equals("3")) {

                    } else {
                        System.out.println("Operação invalida! tente novamente.");
                        espere();
                    }
                } // fim do loop: menu apagar
            } else if (operacao.equals("4")) {
                sistema.salvar();
                System.out.println("Informações salvas");
                espere();

            } else {
                System.out.println("Operação invalida, Tente novamente!");
                espere();
            }
        } // fim do loop: menu principal

        System.out.println("Fim do programa!");
        // Salvando os dados
        sistema.salvar();
        scan.close();
    }

    private void loopCadastros() {
        while (true) {
            clean();
            System.out.println("===== Cadastros =====");
            System.out.println("1. Cadastrar Aparelho");
            System.out.println("2. Cadastrar Funcionario");
            System.out.println("3. Cadastrar Ordem de serviço");
            System.out.println("0. Voltar");
            System.out.print("Operação: ");
            String operacaoCad = scan.nextLine();

            if (operacaoCad.equals("0")) {
                break;
            } else if (operacaoCad.equals("1")) {
                clean();
                String marca, modelo, descricao;
                System.out.println("===== Cadastro de Aparelho =====");
                System.out.print("Marca do Aparelho: ");
                marca = scan.nextLine();
                System.out.print("Modelo do aparelho: ");
                modelo = scan.nextLine();
                System.out.print("Descrição: ");
                descricao = scan.nextLine();

                sistema.cadastrarNovoAparelho(marca, modelo, descricao);
                System.out.println("Cadastro realizado com sucesso!");
                espere();

            } else if (operacaoCad.equals("2")) {
                clean();
                String nome, user, senha;
                System.out.println("===== Cadasto de Funcionários =====");
                System.out.print("Nome do Funcionário: ");
                nome = scan.nextLine();
                System.out.print("Nome de Usuário: ");
                user = scan.nextLine();
                System.out.print("Senha: ");
                senha = scan.nextLine();

                sistema.cadastrarNovoFuncionario(nome, user, senha);
                System.out.println("Funcionário cadastrado com sucesso!");
                espere();

            } else if (operacaoCad.equals("3")) {
                clean();
                String status, descricao; // ap, fu;
                System.out.println("===== Cadasto de Ordem de serviço =====");
                System.out.print("Status: ");
                status = scan.nextLine();
                System.out.print("Descrição: ");
                descricao = scan.nextLine();
                System.out.print("Aparelho: ");
                // ap = scan.nextLine();
                System.out.print("Funcionario: ");
                // fu = scan.nextLine();

                sistema.cadastrarNovaOs(status, descricao, new Aparelho(), new Funcionario());
                espere();
            } else {
                System.out.println("Operação invalida! tente novamente.");
                espere();
            }
        } // fim do loop: menu de cadastros
    }

    private void loopConsultas() {
        while (true) {
            clean();
            System.out.println("===== Consultas =====");
            System.out.println("1. Consultar Aparelho");
            System.out.println("2. Consultar Funcionario");
            System.out.println("3. Consultar Ordem de serviço");
            System.out.println("0. Voltar");
            System.out.print("Operação: ");
            String operacaoCad = scan.nextLine();

            if (operacaoCad.equals("0")) {
                break;
            } else if (operacaoCad.equals("1")) {

            } else if (operacaoCad.equals("2")) {

            } else if (operacaoCad.equals("3")) {

            } else {
                System.out.println("Operação invalida! tente novamente.");
                espere();
            }
        } // fim do loop: menu consultas
    }

    private void clean() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

    }

    private void espere() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
