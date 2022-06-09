package br.ufpb.nycolas.ui;

import java.io.IOException;
import java.util.Scanner;

public class MenuTerminal implements Menu {

    public MenuTerminal() {
        this.init();
    }

    public void init() {
        Scanner scan = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            clean();
            System.out.println("===== Assistência técnica =====");
            System.out.println("Menu: ");
            System.out.println("1. Cadastros");
            System.out.println("2. Consultas");
            System.out.println("3. Apagar");
            System.out.println("0. sair");
            System.out.print("Operação: ");
            String operacao = scan.nextLine();

            if (operacao.equals("0")) {
                continuar = false;

            } else if (operacao.equals("1")) {

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

                    } else if (operacaoCad.equals("2")) {

                    } else if (operacaoCad.equals("3")) {

                    } else {
                        System.out.println("Operação invalida! tente novamente.");
                        espere();
                    }
                } // fim do loop: menu de cadastros

            } else if (operacao.equals("2")) {

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

            } else if (operacao.equals("3")) {

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
            } else {
                System.out.println("Operação invalida, Tente novamente!");
                espere();
            }
        } // fim do loop: menu principal

        System.out.println("Fim do programa!");
        scan.close();
    }

    public void clean() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

    }

    public void espere() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
