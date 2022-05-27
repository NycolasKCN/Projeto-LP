package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.Aparelho;
//import br.ufpb.nycolas.sistema.Funcionario;
//import br.ufpb.nycolas.sistema.OrdemDeServico;

public class TestaManual {
    public static void main(String[] args) {
        LoadDataArq db = new LoadDataArq();

        Aparelho a = new Aparelho();
        db.cadastrarAparelho(a);

        Aparelho b = new Aparelho(10001, "Apple", "Iphone 7 128gb", "Camera trazeira quebrada");
        db.cadastrarAparelho(b);

        Aparelho c = new Aparelho(10002, "Samsung", "A10 256gb", "tela trincada");
        db.cadastrarAparelho(c);

        db.salvarDados();

        List<Aparelho> aparelhos = db.getAparelhos();

        for (Aparelho i : aparelhos) {
            System.out.println(i);
        }
    }
}