package br.ufpb.nycolas.dados;

import java.util.ArrayList;

import br.ufpb.nycolas.sistema.Aparelho;

public class testLerBancoDeDados {
    public static void main(String[] args) {
       LerBancoDeDados db = new LerBancoDeDados();
       ArrayList<Aparelho> list = db.populateAparelhos();

       for (Aparelho a : list) {
           System.out.println(a.toString());
       }
    }
}
