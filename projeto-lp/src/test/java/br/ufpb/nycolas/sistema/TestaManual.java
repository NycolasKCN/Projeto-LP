package br.ufpb.nycolas.sistema;

public class TestaManual { 
    public static void main(String[] args) {
        Servicos servico = new Servicos();

        Aparelho a = servico.cadastrarNovoAparelho("apple", "Iphone 13 pro", "Lacrado");
        Funcionario f = servico.cadastrarNovoFuncionario("Nycolas Kevin", "nyc", "191102rt");
        servico.cadastrarNovaOs("Recebido", "Aparelho lacrado, mas não liga", a, f);
        servico.salvar();

    }
}
