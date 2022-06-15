package br.ufpb.nycolas.sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAparelho {
    @Test
    public void TestaConstrutorTodosDeclarados() {
        String id = "2";
        String marca = "Apple";
        String modelo = "Iphone 7";
        String proprietario = "joselia";

        Aparelho a = new Aparelho(id, marca, modelo, proprietario);
        assertEquals(id, a.getId());
        assertEquals(marca, a.getMarca());
        assertEquals(modelo, a.getModelo());
        assertEquals(proprietario, a.getProprietario());
    }

    @Test
    public void testaConstrutorNenhumDeclarado() {
        Aparelho a = new Aparelho();
        assertEquals("0", a.getId());
        assertEquals("vazio", a.getMarca());
        assertEquals("vazio", a.getModelo());
        assertEquals("vazio", a.getProprietario());
    }

    @Test
    public void testaSetters() {
        String id = "1";
        String marca = "xiomi";
        String modelo = "note 10";
        String proprietario = "junior";

        Aparelho a = new Aparelho(id, marca, modelo, proprietario);

        a.setId("44");
        a.setMarca("xiaomi");
        a.setModelo("a10");
        a.setProprietario("Laura");

        assertEquals("44", a.getId());
        assertEquals("xiaomi", a.getMarca());
        assertEquals("a10", a.getModelo());
        assertEquals("Laura", a.getProprietario());
    }
}
