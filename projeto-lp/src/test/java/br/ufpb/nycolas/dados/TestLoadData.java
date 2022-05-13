package br.ufpb.nycolas.dados;

import java.util.List;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestLoadData {
    @Test
    public void testCarregamentoDeDados() {
        LoadDataSql db = new LoadDataSql();
        List<Aparelho> listAparelhos = db.loadAparelhos();
        List<Funcionario> listFuncionarios = db.loadFuncionarios();

        assertEquals(3, listAparelhos.size());
        assertEquals("apple", listAparelhos.get(0).getMarca());
        assertEquals("note 10 128gb", listAparelhos.get(1).getModelo());
        assertEquals("vermelho", listAparelhos.get(2).getDescricao());

        assertEquals(3, listFuncionarios.size());
    }
}
