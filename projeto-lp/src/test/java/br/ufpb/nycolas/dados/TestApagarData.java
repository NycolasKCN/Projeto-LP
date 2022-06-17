package br.ufpb.nycolas.dados;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

@TestInstance(Lifecycle.PER_CLASS)
public class TestApagarData {
    private LoadDataArq db;

    @Disabled
    @BeforeAll
    public void carregarDados() {
        String caminhoAparelho = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\AparelhosDB.txt";
        String caminhoFuncionario = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\FuncionarioDB.txt";
        String caminhoOs = "C:\\Scripts\\Java\\projetos\\Projeto-LP\\projeto-lp\\src\\main\\java\\br\\ufpb\\nycolas\\dados\\db\\OrdensDeServicoDB.txt";
        File fileAparelho = new File(caminhoAparelho);
        File fileFuncionarios = new File(caminhoFuncionario);
        File fileOs = new File(caminhoOs);

        fileAparelho.delete();
        fileFuncionarios.delete();
        fileOs.delete();

        db = new LoadDataArq();

        db.cadastrarAparelho(new Aparelho());

        /**
         * 302;na loja;Iphone 13 com bateria estufada;101;201;
            303;ok;a10 com tela trincada;102;201;
            304;sem conserto;iphone 7 plus, placa mae nao tem jeito;101;201;

            201;nycolas kevin;nyc;191102rt;

            101;apple;iphone 7 plus 128gb preto;junior;
            102;samsung;a10 16gb vermelho;yasmim;
         */

        Aparelho apA = new Aparelho("10002", "Samsung", "A10 256gb", "tela trincada");
        Funcionario fA = new Funcionario("20001", "Nycolas Kevin", "nyc", "191102");
        OrdemDeServico a = new OrdemDeServico("30001", "Entregue", "Descrição....", apA, fA);
        db.cadastrarAparelho(apA);
        db.cadastrarFuncionario(fA);
        db.cadastrarOs(a);

        Aparelho apB = new Aparelho("10001", "Apple", "Iphone 7 128gb", "Camera trazeira quebrada");
        Funcionario fB = new Funcionario("20002", "Carla Costa", "nyc", "191102");
        OrdemDeServico b = new OrdemDeServico("30002", "Não recebido", "Descrição......", apB, fB);
        db.cadastrarAparelho(apB);
        db.cadastrarFuncionario(fB);
        db.cadastrarOs(b);

        Aparelho apC = new Aparelho("10003", "Samsung", "A10 256gb", "tela trincada");
        Funcionario fC = new Funcionario("20003", "Joselia Nascimento", "nyc", "191102");
        OrdemDeServico c = new OrdemDeServico("30003", "Em andamento", "Aparelho etc etc", apC, fC);
        db.cadastrarAparelho(apC);
        db.cadastrarFuncionario(fC);
        db.cadastrarOs(c);

    }

    @AfterAll
    public void salvarDados() {
        db.salvarDados();
    }

    @Test
    public void apagarAparelho() {
        Aparelho a = new Aparelho();
        assertTrue(db.apagarAparelho(a));

        Aparelho b = new Aparelho("10025", "Iphone", "Apple", "sei lá");
        assertFalse(db.apagarAparelho(b));

        Aparelho c = new Aparelho("10002", "Samsung", "A10 256gb", "tela trincada");
        assertTrue(db.apagarAparelho(c));
    }

    @Test
    public void apagarFuncionario() {

    }

    @Test
    public void apagarOs() {

    }
}