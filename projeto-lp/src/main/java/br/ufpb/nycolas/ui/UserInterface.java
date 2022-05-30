package br.ufpb.nycolas.ui;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        System.out.println("===== Assistência técnica =====");
        System.out.println("Menu: ");
        System.out.println("1. Cadastros");
        System.out.println("2. Consultas");
        System.out.println("3. Gerenciar");
        System.out.print("Operação: ");
        Scanner scan = new Scanner(System.in);

        String operacao = scan.nextLine();

        scan.close();
    }
}
