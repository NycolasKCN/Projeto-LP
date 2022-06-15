package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;

@Disabled
public class TestServicos {
    @Test
    public void testConsultarFuncionarioPeloNome() {
        Servicos api = new Servicos();
        String nomeFuncionarioExistente = "Nycolas Kevin";
        Funcionario f;
        try {
            f = api.consultarFuncionarioPeloNome(nomeFuncionarioExistente);
            assertEquals(nomeFuncionarioExistente, f.getNome());
        } catch (FuncionarioNaoExisteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String nomeFuncionarioInexistente = "yanii";
        Funcionario f2;
        try {
            f2 = api.consultarFuncionarioPeloNome(nomeFuncionarioInexistente);
            assertEquals(null, f2);
        } catch (FuncionarioNaoExisteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testConsultarAparelhoPeloModelo() {
        String modeloExistente = "Iphone 7 128gb";
        Servicos api = new Servicos();
        Aparelho a;
        try {
            a = api.consultarAparelhoPorModelo(modeloExistente);
            assertEquals(modeloExistente, a.getModelo());
        } catch (AparelhoNaoExisteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String modeloInexistente = "lite preto";
        Aparelho a2;
        try {
            a2 = api.consultarAparelhoPorModelo(modeloInexistente);
            assertEquals(null, a2);
        } catch (AparelhoNaoExisteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
