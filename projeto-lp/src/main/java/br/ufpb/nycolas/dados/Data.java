package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.*;

public interface Data {
    public List<Aparelho> loadAparelhos();
    public List<Funcionario> loadFuncionarios();
    public List<OrdemDeServico> loadOrdemDeServicos();

    public boolean cadastrarAparelho();
    public boolean cadastrarFuncionario();
    public boolean cadastrarOs();

}
