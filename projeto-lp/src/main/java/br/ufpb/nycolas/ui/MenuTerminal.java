package br.ufpb.nycolas.ui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.ufpb.nycolas.exceptions.AparelhoNaoExisteException;
import br.ufpb.nycolas.exceptions.FuncionarioNaoExisteException;
import br.ufpb.nycolas.exceptions.OsNaoExisteException;
import br.ufpb.nycolas.sistema.Aparelho;
import br.ufpb.nycolas.sistema.Funcionario;
import br.ufpb.nycolas.sistema.OrdemDeServico;
import br.ufpb.nycolas.sistema.Servicos;

/**
 * User Interface.
 * 
 * @author Nycolas Kevin
 */
public class MenuTerminal implements Menu {

    private Scanner scan = new Scanner(System.in);
    private Servicos sistema = new Servicos();

    public MenuTerminal() {
    }

    /**
     * Metodo que inicia o sistema e o terminal do programa.
     * Possue o laço principal do programa
     */
    public void init() {

        boolean continuar = true;

        while (continuar) {
            clean();
            System.out.println("===== Assistência técnica =====");
            System.out.println("Menu: ");
            System.out.println("1. Cadastros");
            System.out.println("2. Consultas");
            System.out.println("3. Apagar");
            System.out.println("4. Salvar");
            System.out.println("0. sair");
            System.out.print("Operação: ");
            String operacao = scan.nextLine();

            if (operacao.equals("0")) {
                continuar = false;

            } else if (operacao.equals("1")) { // Cadastros
                loopCadastros();

            } else if (operacao.equals("2")) { // Consultas
                loopConsultas();
            } else if (operacao.equals("3")) { // Apagar
                loopApagar();
            } else if (operacao.equals("4")) {
                sistema.salvar();
                System.out.println("Informações salvas");
                espere();

            } else {
                System.out.println("Operação invalida, Tente novamente!");
                espere();
            }
        } // fim do loop: menu principal

        // Salvando os dados
        sistema.salvar();
        System.out.println("Dados salvos");
        scan.close();
    }

    /**
     * Loop para o menu de cadastros.
     */
    private void loopCadastros() {
        while (true) {
            clean();
            System.out.println("===== Cadastros =====");
            System.out.println("1. Cadastrar Aparelho");
            System.out.println("2. Cadastrar Funcionario");
            System.out.println("3. Cadastrar Ordem de serviço");
            System.out.println("0. Voltar");
            System.out.print("Operação: ");
            String operacaoCad = scan.nextLine();

            if (operacaoCad.equals("0")) {
                break;
            } else if (operacaoCad.equals("1")) {
                cadAparelho();
            } else if (operacaoCad.equals("2")) {
                cadFuncionario();

            } else if (operacaoCad.equals("3")) {
                cadOs();
            } else {
                System.out.println("Operação invalida! tente novamente.");
                espere();
            }
        } // fim do loop: menu de cadastros
    }

    /**
     * Loop para o menu de consultas.
     */
    private void loopConsultas() {
        while (true) {
            clean();
            System.out.println("===== Consultas =====");
            System.out.println("1. Listar todos Aparelho");
            System.out.println("2. Listar todos Funcionario");
            System.out.println("3. Listar todos Ordem de serviço");
            System.out.println("4. Buscar Aparelhos por proprietario");
            System.out.println("5. Buscar Funcionarios pelo nome");
            System.out.println("6. Buscar OS por funcionario responsavel");
            System.out.println("0. Voltar");
            System.out.print("Operação: ");
            String operacaoCad = scan.nextLine();

            if (operacaoCad.equals("0")) {
                break;
            } else if (operacaoCad.equals("1")) {
                tabelaAparelho();
                System.out.print("Pressione enter para continuar.");
                scan.nextLine();
            } else if (operacaoCad.equals("2")) {
                tabelaFuncionario();
                System.out.print("Pressione enter para continuar.");
                scan.nextLine();
            } else if (operacaoCad.equals("3")) {
                tabelaOs();
                System.out.print("Pressione enter para continuar.");
                scan.nextLine();
            } else if (operacaoCad.equals("4")) {
                buscarAparelhoNome();
            } else if (operacaoCad.equals("5")) {
                buscarFuncionarioNome();
            } else if (operacaoCad.equals("6")) {
                buscarOsPorFuncionario();
            } else {
                System.out.println("Operação invalida! tente novamente.");
                espere();
            }
        } // fim do loop: menu consultas
    }

    /**
     * Loop para o menu de apagar.
     */
    private void loopApagar() {
        while (true) {
            clean();
            System.out.println("===== Apagar =====");
            System.out.println("1. Apagar Aparelho");
            System.out.println("2. Apagar Funcionario");
            System.out.println("3. Apagar Ordem de serviço");
            System.out.println("0. Voltar");
            System.out.print("Operação: ");
            String operacaoCad = scan.nextLine();

            if (operacaoCad.equals("0")) {
                break;
            } else if (operacaoCad.equals("1")) {
                apagaAparelho();
            } else if (operacaoCad.equals("2")) {
                apagaFuncionario();
            } else if (operacaoCad.equals("3")) {
                apagaOs();
            } else {
                System.out.println("Operação invalida! tente novamente.");
                espere();
            }
        } // fim do loop: menu apagar
    }

    /**
     * Recebe os dados do usuario e cadastra um novo {@code Aparelho}.
     */
    private void cadAparelho() {
        clean();
        String marca, modelo, proprietario;
        System.out.println("===== Cadastro de Aparelho =====");
        System.out.print("Marca do Aparelho: ");
        marca = scan.nextLine();
        System.out.print("Modelo do aparelho: ");
        modelo = scan.nextLine();
        System.out.print("Nome do proprietario: ");
        proprietario = scan.nextLine();

        sistema.cadastrarNovoAparelho(marca, modelo, proprietario);
        System.out.println("Cadastro realizado com sucesso!");
        espere();

    }

    /**
     * Recebe os dados do usuario e cadastra um novo {@code Funcionario}.
     */
    private void cadFuncionario() {
        clean();
        String nome, user, senha;
        System.out.println("===== Cadasto de Funcionários =====");
        System.out.print("Nome do Funcionário: ");
        nome = scan.nextLine();
        System.out.print("Nome de Usuário: ");
        user = scan.nextLine();
        System.out.print("Senha: ");
        senha = scan.nextLine();

        sistema.cadastrarNovoFuncionario(nome, user, senha);
        System.out.println("Funcionário cadastrado com sucesso!");
        espere();
    }

    /**
     * Recebe os dados do usuario e cadastra uma nova {@code OrdemDeServico}.
     */
    private void cadOs() {
        clean();
        String status, descricao, cliente, funcionario;
        System.out.println("===== Cadasto de Ordem de serviço =====");
        System.out.print("Status: ");
        status = scan.nextLine();
        System.out.print("Descrição: ");
        descricao = scan.nextLine();
        System.out.print("Nome do cliente: ");
        cliente = scan.nextLine();
        System.out.print("Nome do Funcionario: ");
        funcionario = scan.nextLine();

        try {
            sistema.cadastrarNovaOs(status, descricao, cliente, funcionario);
            System.out.println("Ordem de serviço registrada!");
        } catch (AparelhoNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (FuncionarioNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
            System.out.println(e);
        }
        espere();
    }

    /**
     * Imprime um tabela com todos os aparelhos.
     * 
     */
    private void tabelaAparelho() {
        clean();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %30s", "ID", "MARCA", "MODELO");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        boolean primeiraRepetição = true;
        for (Aparelho a : sistema.getAparelhos()) {
            if (primeiraRepetição) {
                primeiraRepetição = false;
                continue;
            }
            System.out.format("%10s %20s %30s", a.getId(), a.getMarca(), a.getModelo());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Imprime uma tabela com todos os funcionarios.
     */
    private void tabelaFuncionario() {
        clean();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %10s", "ID", "NOME", "USUARIO");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        boolean primeiraRepetição = true;
        for (Funcionario f : sistema.getFuncionarios()) {
            if (primeiraRepetição) {
                primeiraRepetição = false;
                continue;
            }
            System.out.format("%10s %20s %10s", f.getId(), f.getNome(), f.getUsuario());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Imprime uma tabela com todas as ordens de serviço.
     */
    private void tabelaOs() {
        clean();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s", "ID", "STATUS", "FUNCIONARIO");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        boolean primeiraRepetição = true;
        for (OrdemDeServico os : sistema.getOs()) {
            if (primeiraRepetição) {
                primeiraRepetição = false;
                continue;
            }
            System.out.format("%10s %20s %20s", os.getId(), os.getStatus(), os.getFuncionarioResponsavel().getNome());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Recebe os dados do usuario e apaga o {@code Aparelho}, se ele existir.
     */
    private void apagaAparelho() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("===== Apagar aparelho =====");
            tabelaAparelho();
            System.out.println("Digite o id para apagar o Aparelho que deseja.");
            System.out.println("Digite '0' para voltar e não apagar nada.");
            System.out.print("ID: ");
            String idAparelho = scan.nextLine();

            if (idAparelho.equals("0")) {
                continuar = false;
                continue;
            }

            try {
                sistema.apagarAparelhoPorId(idAparelho);
                System.out.println("Aparelho apagado com sucesso!");
            } catch (AparelhoNaoExisteException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
                System.out.println(e);
            }

            espere();
        }
    }

    /**
     * Recebe os dados do usuario e apaga o {@code Funcionario}, se ele existir.
     */
    private void apagaFuncionario() {

        boolean continuar = true;
        while (continuar) {
            System.out.println(("===== Apagar funcionário ====="));
            tabelaFuncionario();
            System.out.println("Digite o id para apagar o funcionário que deseja.");
            System.out.println("Digite '0' para voltar e não apagar nada.");
            System.out.print("ID: ");
            String idFuncionario = scan.nextLine();

            if (idFuncionario.equals("0")) {
                continuar = false;
                continue;
            }
            try {
                sistema.apagarFuncionarioPorId(idFuncionario);
                System.out.println("Funcionário apagado com sucesso!");
            } catch (FuncionarioNaoExisteException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
                System.out.println(e);
            }

            espere();
        }
    }

    /**
     * Recebe os dados do usuario e apaga a {@code OrdemDeServico}, se ela existir.
     */
    private void apagaOs() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("===== Apagar OS =====");
            tabelaOs();
            System.out.println("Digite o id para apagar a Ordem de serviço que deseja.");
            System.out.println("Digite '0' para voltar e não apagar nada.");
            System.out.print("ID: ");
            String idOs = scan.nextLine();

            if (idOs.equals("0")) {
                continuar = false;
                continue;
            }

            try {
                sistema.apagarOsPorId(idOs);
                System.out.println("Ordem de serviço apagada com sucesso");
                continuar = false;
            } catch (OsNaoExisteException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
                System.out.println(e);
            }

            espere();
        }
    }

    /**
     * Recebe os dados do usuario e imprime os {@code Aparelhos} encontrados.
     */
    private void buscarAparelhoNome() {
        clean();
        System.out.println("===== Buscar Aparelho =====");
        System.out.print("Digite o nome do proprietário: ");
        String proprietario = scan.nextLine();

        try {
            System.out.println("Resultado da consulta: ");
            System.out.println("-----------------------------------------------------------------------------");
            List<Aparelho> querry = sistema.consultarAparelhosPorProp(proprietario);
            System.out.printf("%10s %20s %30s", "ID", "MARCA", "MODELO");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");

            for (Aparelho a : querry) {
                System.out.format("%10s %20s %30s", a.getId(), a.getMarca(), a.getModelo());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------");
            visualizarInformacoesAparelho();

        } catch (AparelhoNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
            System.out.println(e);
        }
        System.out.print("Enter para continuar.");
        scan.nextLine();
    }

    /**
     * Recebe os dados do usuario e imprime os {@code Funcionarios} encontrados.
     */
    private void buscarFuncionarioNome() {
        clean();
        System.out.println("===== Buscar Funcionário =====");
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = scan.nextLine();

        try {
            List<Funcionario> querry = sistema.consultarFuncionariosPeloNome(nomeFuncionario);
            System.out.println("Resultado:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%10s %20s %10s", "ID", "NOME", "USUARIO");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            for (Funcionario f : querry) {
                System.out.format("%10s %20s %10s", f.getId(), f.getNome(), f.getUsuario());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------");
            visualizarInformacoesFuncionario();
        } catch (FuncionarioNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Um erro desconhecido aconteceu! mais detalhes a baixo.");
            System.out.println(e);
        }
        System.out.print("Enter para continuar.");
        scan.nextLine();
    }

    /**
     * Recebe os dados do usuario e imprime as {@code OrdensDeServico} encontradas.
     */
    private void buscarOsPorFuncionario() {
        clean();
        System.out.println("===== Buscar Ordem de serviço =====");
        System.out.print("Digite o nome do Funcionario responsavel: ");
        String nomeFuncionario = scan.nextLine();

        try {
            List<OrdemDeServico> querry = sistema.consultarOSdeFuncionario(nomeFuncionario);
            System.out.println("Resultado:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%10s %20s %20s", "ID", "STATUS", "FUNCIONARIO");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            for (OrdemDeServico os : querry) {
                System.out.format("%10s %20s %20s", os.getId(), os.getStatus(),
                        os.getFuncionarioResponsavel().getNome());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------");
            visualizarInformacoesOs();
        } catch (OsNaoExisteException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter para continuar.");
        scan.nextLine();
    }

    /**
     * Imprime as informações de um aparelho.
     * 
     * @throws AparelhoNaoExisteException Caso o aparelho não exista.
     */
    private void visualizarInformacoesAparelho() throws AparelhoNaoExisteException {
        System.out.println("Para visualizar mais informações de um Aparelho, digite o id.");
        System.out.println("Digite '0' para voltar.");
        System.out.print("Id: ");
        String idQuerry = scan.nextLine();

        if (idQuerry.equals("0")) {
            return;
        }
        Aparelho consultedAparelho = sistema.consultarAparelhoPorId(idQuerry);

        System.out.println("Resultado: ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Marca: " + consultedAparelho.getMarca());
        System.out.println("Modelo: " + consultedAparelho.getModelo());
        System.out.println("Proprietário: " + consultedAparelho.getProprietario());
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Imprime as informações de um Funcionario.
     * 
     * @throws FuncionarioNaoExisteException Caso o funcionário não exista.
     */
    private void visualizarInformacoesFuncionario() throws FuncionarioNaoExisteException {
        System.out.println("Para visualizar mais informações de um Funcionario, digite o id.");
        System.out.println("Digite '0' para voltar.");
        System.out.print("Id: ");
        String idQuerry = scan.nextLine();

        if (idQuerry.equals("0")) {
            return;
        }
        Funcionario consultedFuncionario = sistema.consultarFuncionarioPorId(idQuerry);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Nome: " + consultedFuncionario.getNome());
        System.out.println("Usuário: " + consultedFuncionario.getUsuario());
        System.out.println("Senha: " + consultedFuncionario.getSenha());
        System.out.println("-----------------------------------------------------------------------------");

    }

    /**
     * Imprime as informações de uma Ordem de serviço.
     * 
     * @throws OsNaoExisteException Caso a OrdemDeServico não exista.
     */
    private void visualizarInformacoesOs() throws OsNaoExisteException {
        System.out.println("Para visualizar mais informações de uma Ordem de serviço, digite o id.");
        System.out.println("Digite '0' para voltar.");
        System.out.print("Id: ");
        String idQuerry = scan.nextLine();

        if (idQuerry.equals("0")) {
            return;
        }
        OrdemDeServico consultedOs = sistema.consultarOSdeId(idQuerry);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Status: " + consultedOs.getStatus());
        System.out.println("Descrição: " + consultedOs.getDescricaoProblema());
        System.out.println("Nome do funcionário responsavel: " + consultedOs.getFuncionarioResponsavel().getNome());
        System.out.println("Nome do Cliente: " + consultedOs.getAparelhoVinculado().getProprietario());
        System.out.println("Modelo do aparelho: " + consultedOs.getAparelhoVinculado().getModelo());
        System.out.println("-----------------------------------------------------------------------------");

    }

    /**
     * Limpa o terminal.
     */
    private static void clean() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

    }

    /**
     * Pausa o precesso por um estante.
     */
    private static void espere() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}