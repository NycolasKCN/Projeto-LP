package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.*;

public interface Data {

    public List<Aparelho> loadAparelhos();

    public List<Funcionario> loadFuncionarios();

    public List<OrdemDeServico> loadOrdemDeServicos();

    public List<Aparelho> getAparelhos();

    public List<Funcionario> getFuncionarios();

    public List<OrdemDeServico> getOrdemDeServicos();

    public boolean cadastrarAparelho(Aparelho aparelho);

    public boolean cadastrarFuncionario(Funcionario funcionario);

    public boolean cadastrarOs(OrdemDeServico os);

    public boolean apagarAparelho(Aparelho aparelho);

    public boolean apagarFuncionario(Funcionario funcionario);

    public boolean apagarOs(OrdemDeServico os);

    public boolean salvarDados();

    public boolean arquivoExiste(String caminho);

}
