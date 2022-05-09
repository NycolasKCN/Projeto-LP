package br.ufpb.nycolas.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TestBancoDeDados {
    @Test
    public void testArquivoExiste() {
        BancoDeDados db = new BancoDeDados();
        assertTrue(db.arquivosExistem());
    }
}
