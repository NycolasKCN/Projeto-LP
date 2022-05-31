package br.ufpb.nycolas.ui;

import java.util.Scanner;


public class UiTerminal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("===== Assistência técnica =====");
        System.out.println("Menu: ");
        System.out.println("1. Cadastros");
        System.out.println("2. Consultas");
        System.out.println("3. Gerenciar");
        System.out.println("999. sair");
        boolean continuar = true;
        while (continuar) {
            System.out.print("Operação: ");
            String operacao = scan.nextLine();

            if (operacao.equals("999")) {
                break;
            }
        }

        scan.close();
    }
}
