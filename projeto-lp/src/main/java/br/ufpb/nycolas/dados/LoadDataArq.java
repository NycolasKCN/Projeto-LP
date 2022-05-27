package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

public class LoadDataArq implements Data {

    @Override
    public List<Aparelho> loadAparelhos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Funcionario> loadFuncionarios() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrdemDeServico> loadOrdemDeServicos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean arquivoExiste(String caminho) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cadastrarAparelho(Aparelho aparelho) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cadastrarOs(OrdemDeServico os) {
        // TODO Auto-generated method stub
        return false;
    }

}