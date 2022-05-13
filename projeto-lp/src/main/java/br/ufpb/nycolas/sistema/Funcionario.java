package br.ufpb.nycolas.sistema;

public class Funcionario {

    private int id;
    private String nome;
    private String usuario;
    private String senha;

    /**
     * Construtor sem nenhum parametro
     */
    public Funcionario() {
        this(0,"","","");
    }

    /**
     * Construtor com todos os parametros
     * @param id id do funcionario
     * @param nome nome do funcionario
     * @param usuario usuario para entrada do funcionario
     * @param senha senha do funcionario
     */
    public Funcionario(int id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * 
     * @return Retorna o id do funcionario
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param novoId Novo id do funcionario
     */
    public void setId(int novoId) {
        this.id = novoId;
    }

    /**
     * @return Retorna o nome do funcionario
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param novoNome Novo nome do funcionario
     */
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    /**
     * @return Retorna o nome de usuario do funcionario
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * @param novoUsuario Novo usuario do funcionario
     */
    public void setUsuario(String novoUsuario) {
        this.usuario = novoUsuario;
    }

    /**
     * @return retorna a senha do funcionario
     */
    public String getSenha() {
        return this.senha;
    }

    /**
     * @param novaSenha Nova senha do funcionario
     */
    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

}
