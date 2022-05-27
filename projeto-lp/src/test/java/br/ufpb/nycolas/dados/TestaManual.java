package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.OrdemDeServico;


public class TestaManual {
    public static void main(String[] args) {
        LoadDataArq db = new LoadDataArq();

        List<OrdemDeServico> listaOs = db.getOrdemDeServicos();
        for (OrdemDeServico os : listaOs){
            System.out.println(os.toString());
        }
    }
}