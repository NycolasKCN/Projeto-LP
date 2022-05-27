package br.ufpb.nycolas.dados;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

public class TestaManual{
    public static void main(String[] args) {
        Data loadData = new LoadDataArq();

        for(Aparelho a : loadData.getAparelhos()){
            System.out.println(a.toString());
        }
        System.out.println("");
        for(Funcionario a : loadData.getFuncionarios()){
            System.out.println(a.toString());
        }
        System.out.println("");
        for(OrdemDeServico a : loadData.getOrdemDeServicos()){
            System.out.println(a.toString());
        }
    }
}