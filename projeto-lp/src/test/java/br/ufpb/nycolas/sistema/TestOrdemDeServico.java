package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class TestOrdemDeServico {
    @Test
    public void TestaConstrutorTodosDeclarados() {
        String id = "2";
        String status = "Na loja";
        String descricao = "Aparelho com problema no audio";

        // TODO: Atualizar os testes
        OrdemDeServico a = new OrdemDeServico(id, status, descricao, new Aparelho(), new Funcionario());
        assertEquals(id, a.getId());
        assertEquals(status, a.getStatus());
        assertEquals(descricao, a.getDescricaoProblema());
    }

    @Test
    public void testaConstrutorNenhumDeclarado() {
        OrdemDeServico a = new OrdemDeServico();
        assertEquals("0", a.getId());
        assertEquals("vazio", a.getStatus());
        assertEquals("vazio", a.getDescricaoProblema());
    }

    @Test
    public void testaSetters() {
        String id = "1";
        String status = "na loja";
        String descricao = "Aparelho com tela trincada";

        String novoId = "44";
        String novoStatus = "entregue";
        String novoDescricao = "Aparelho com tela trocada";

        // TODO: Atualizar os testes
        OrdemDeServico a = new OrdemDeServico(id, status, descricao, new Aparelho(), new Funcionario());

        a.setId(novoId);
        a.setStatus(novoStatus);
        a.setDrescricaoProblema(novoDescricao);

        assertEquals(novoId, a.getId());
        assertEquals(novoStatus, a.getStatus());
        assertEquals(novoDescricao, a.getDescricaoProblema());
    }
}
