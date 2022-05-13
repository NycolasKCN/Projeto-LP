package br.ufpb.nycolas.dados;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;

public class TestApiBancoDeDados {
    @Test
    public void testConsultarFuncionarioPeloNome() {
        ApiBancoDeDados api = new ApiBancoDeDados();
        String nomeFuncionarioExistente = "nycolas kevin";
        Funcionario f = api.consultarFuncionarioPeloNome(nomeFuncionarioExistente);
        assertEquals(nomeFuncionarioExistente, f.getNome());

        String nomeFuncionarioInexistente = "yanni sophia";
        Funcionario f2 = api.consultarFuncionarioPeloNome(nomeFuncionarioInexistente);
        assertEquals(null, f2);

    }

    @Test
    public void testConsultarAparelhoPeloModelo() {
        String modeloExistente = "Iphone 7 128gb";
        ApiBancoDeDados api = new ApiBancoDeDados();
        Aparelho a = api.consultarAparelhoPorModelo(modeloExistente);
        assertEquals(modeloExistente, a.getModelo());

        String modeloInexistente = "Asus s8";
        Aparelho a2 = api.consultarAparelhoPorModelo(modeloInexistente);
        assertEquals(null, a2);

    }
}
