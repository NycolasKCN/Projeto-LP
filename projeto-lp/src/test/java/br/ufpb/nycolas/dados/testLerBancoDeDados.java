package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;

public class testLerBancoDeDados {
    public static void main(String[] args) {
        LerBancoDeDados db = new LerBancoDeDados();
        List<Aparelho> listAparelhos = db.populateAparelhos();
        List<Funcionario> listFuncionarios = db.populateFuncionarios();

        for (Aparelho a : listAparelhos) {
            System.out.println(a.toString());
        }
        
        System.out.println();

        for (Funcionario f : listFuncionarios) {
            System.out.println(f.toString());
        }
    }
}
