package br.ufpb.nycolas.sistema;

public class OrdemDeServico {

    private int id;
    private String status;
    private String descricaoProblema;

    /**
     * Construtor padrão, nenhum parametro
     */
    public OrdemDeServico() {
        this.id = 0;
        this.status = "";
        this.descricaoProblema = "";
    }

    public OrdemDeServico(int id, String status, String descricao){
        this.id = id;
        this.status = status;
        this.descricaoProblema = descricao;
    }

    /**
     * @return Retorna o id dessa OS
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param novoId Novo id para essa OS
     */
    public void setId(int novoId) {
        this.id = novoId;
    }

    /**
     * @return retorna o status desta os
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @param novoStatus Novo status da OS
     */
    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    /**
     * @return Retorna a descrição do problema descrito
     */
    public String getDescricaoProblema() {
        return this.descricaoProblema;
    }

    /**
     * @param novaDescricao Nova descrição para está OS
     */
    public void setDrescricaoProblema(String novaDescricao) {
        this.descricaoProblema = novaDescricao;
    }
}
