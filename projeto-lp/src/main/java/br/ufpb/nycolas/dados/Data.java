package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;
import br.ufpb.nycolas.exceptions.OsNaoExisteException;
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

    public void apagarAparelho(Aparelho aparelho) throws AparelhoNaoExisteException;

    public void apagarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException;

    public void apagarOs(OrdemDeServico os) throws OsNaoExisteException;

    public boolean salvarDados();

    public boolean arquivoExiste(String caminho);

}
