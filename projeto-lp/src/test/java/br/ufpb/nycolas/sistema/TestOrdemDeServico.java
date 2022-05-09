package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TestOrdemDeServico {
    @Test
    public void TestaConstrutorTodosDeclarados() {
        int id = 2;
        String status = "Na loja";
        String descricao = "Aparelho com problema no audio";

        OrdemDeServico a = new OrdemDeServico(id, status, descricao);
        assertEquals(id, a.getId());
        assertEquals(status, a.getStatus());
        assertEquals(descricao, a.getDescricaoProblema());
    }

    @Test
    public void testaConstrutorNenhumDeclarado() {
        OrdemDeServico a = new OrdemDeServico();
        assertEquals(0, a.getId());
        assertEquals("", a.getStatus());
        assertEquals("", a.getDescricaoProblema());
    }

    @Test
    public void testaSetters() {
        int id = 1;
        String status = "na loja";
        String descricao = "Aparelho com tela trincada";

        int novoId = 44;
        String novoStatus = "entregue";
        String novoDescricao = "Aparelho com tela trocada";


        OrdemDeServico a = new OrdemDeServico(id, status, descricao);

        a.setId(novoId);
        a.setStatus(novoStatus);
        a.setDrescricaoProblema(novoDescricao);

        assertEquals(novoId, a.getId());
        assertEquals(novoStatus, a.getStatus());
        assertEquals(novoDescricao, a.getDescricaoProblema());
    }
}
