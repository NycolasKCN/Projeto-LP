package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestServicos {
    @Test
    public void testConsultarFuncionarioPeloNome() {
        Servicos api = new Servicos();
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
        Servicos api = new Servicos();
        Aparelho a = api.consultarAparelhoPorModelo(modeloExistente);
        assertEquals(modeloExistente, a.getModelo());

        String modeloInexistente = "Asus s8";
        Aparelho a2 = api.consultarAparelhoPorModelo(modeloInexistente);
        assertEquals(null, a2);

    }
}
