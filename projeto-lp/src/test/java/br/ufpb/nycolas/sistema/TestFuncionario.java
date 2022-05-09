package br.ufpb.nycolas.sistema;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TestFuncionario {
    @Test
    public void TestaConstrutorTodosDeclarados() {
        int id = 2;
        String nome = "Nycolas";
        String usuario = "nycol";
        String senha = "191102rt";

        Funcionario a = new Funcionario(id, nome, usuario, senha);
        assertEquals(id, a.getId());
        assertEquals(nome, a.getNome());
        assertEquals(usuario, a.getUsuario());
        assertEquals(senha, a.getSenha());
    }

    @Test
    public void testaConstrutorNenhumDeclarado() {
        Funcionario a = new Funcionario();
        assertEquals(0, a.getId());
        assertEquals("", a.getNome());
        assertEquals("", a.getUsuario());
        assertEquals("", a.getSenha());
    }

    @Test
    public void testaSetters() {
        int id = 1;
        String nome = "Joselia Costa Nascimento";
        String usuario = "joselia";
        String senha = "191102rt";

        int novoId = 44;
        String novoNome = "Joselia Costa";
        String novoUsuario = "josel";
        String novaSenha = "Rt191102";
        

        Funcionario a = new Funcionario(id, nome, usuario, senha);

        a.setId(novoId);
        a.setNome(novoNome);
        a.setUsuario(novoUsuario);
        a.setSenha(novaSenha);

        assertEquals(novoId, a.getId());
        assertEquals(novoNome, a.getNome());
        assertEquals(novoUsuario, a.getUsuario());
        assertEquals(novaSenha, a.getSenha());
    }
}