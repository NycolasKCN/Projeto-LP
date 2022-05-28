package br.ufpb.nycolas.dados;

import java.io.File;

import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@TestInstance(Lifecycle.PER_CLASS)
public class TestCadastrarData {

    private LoadDataArq db;

    @BeforeAll
    public void deletandoEcriandoNovosDados() {
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
    }

    @AfterAll
    public void salvandoDados() {
        assertTrue(db.salvarDados());
    }

    @Test
    public void testCadastrarAparelho() {
        Aparelho a = new Aparelho();
        assertTrue(db.cadastrarAparelho(a));

        Aparelho b = new Aparelho("10001", "Apple", "Iphone 7 128gb", "Camera trazeira quebrada");
        assertTrue(db.cadastrarAparelho(b));

        Aparelho c = new Aparelho("10002", "Samsung", "A10 256gb", "tela trincada");
        assertTrue(db.cadastrarAparelho(c));
    }

    @Test
    public void testCadastrarFuncionario() {
        Funcionario a = new Funcionario("20001", "Nycolas Kevin", "nyc", "191102");
        assertTrue(db.cadastrarFuncionario(a));

        Funcionario b = new Funcionario("20002", "Carla Costa", "nyc", "191102");
        assertTrue(db.cadastrarFuncionario(b));

        Funcionario c = new Funcionario("20003", "Joselia Nascimento", "nyc", "191102");
        assertTrue(db.cadastrarFuncionario(c));
    }

    @Test
    public void testCadastrarOs() {
        Aparelho apA = new Aparelho("10002", "Samsung", "A10 256gb", "tela trincada");
        Funcionario fA = new Funcionario("20001", "Nycolas Kevin", "nyc", "191102");
        OrdemDeServico a = new OrdemDeServico("30001", "Entregue", "Descrição....", apA, fA);
        assertTrue(db.cadastrarOs(a));

        Aparelho apB = new Aparelho("10001", "Apple", "Iphone 7 128gb", "Camera trazeira quebrada");
        Funcionario fB = new Funcionario("20002", "Carla Costa", "nyc", "191102");
        OrdemDeServico b = new OrdemDeServico("30002", "Não recebido", "Descrição......", apB, fB);
        assertTrue(db.cadastrarOs(b));

        Aparelho apC = new Aparelho("10002", "Samsung", "A10 256gb", "tela trincada");
        Funcionario fC = new Funcionario("20003", "Joselia Nascimento", "nyc", "191102");
        OrdemDeServico c = new OrdemDeServico("30003", "Em andamento", "Aparelho etc etc", apC, fC);
        assertTrue(db.cadastrarOs(c));
    }
}
