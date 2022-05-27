package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAparelho {
    @Test
    public void TestaConstrutorTodosDeclarados() {
        String id = "2";
        String marca = "Apple";
        String modelo = "Iphone 7";
        String descrição = "chip da apple, fabricado na china";

        Aparelho a = new Aparelho(id, marca, modelo, descrição);
        assertEquals(id, a.getId());
        assertEquals(marca, a.getMarca());
        assertEquals(modelo, a.getModelo());
        assertEquals(descrição, a.getDescricao());
    }

    @Test
    public void testaConstrutorNenhumDeclarado() {
        Aparelho a = new Aparelho();
        assertEquals(0, a.getId());
        assertEquals("", a.getMarca());
        assertEquals("", a.getModelo());
        assertEquals("", a.getDescricao());
    }

    @Test
    public void testaSetters() {
        String id = "1";
        String marca = "xiomi";
        String modelo = "note 10";
        String descrição = "fabricado na china";

        Aparelho a = new Aparelho(id, marca, modelo, descrição);

        a.setId("44");
        a.setMarca("xiaomi");
        a.setModelo("a10");
        a.setDescricao("a10, vermelho, camera 10 mp");

        assertEquals(44, a.getId());
        assertEquals("xiaomi", a.getMarca());
        assertEquals("a10", a.getModelo());
        assertEquals("a10, vermelho, camera 10 mp", a.getDescricao());
    }
}
