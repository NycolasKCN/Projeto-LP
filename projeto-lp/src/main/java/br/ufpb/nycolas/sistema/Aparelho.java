package br.ufpb.nycolas.sistema;

public class Aparelho {
    private int id;
    private String marca;
    private String modelo;
    private String descricao;

    /**
     * Default constructor
     */
    public Aparelho() {
    }

    /**
     * @return retorna o id do aparelho
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * @param novoId Novo id do aparelho
     */
    public void setId(int novoId) {
        this.id = novoId;
    }

    /**
     * @return retorna a marca do aparelho
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * @param novaMarca Nova marca do aparelho
     */
    public void setMarca(String novaMarca) {
        this.marca = novaMarca;
    }

    /**
     * @return Retorna o modelo do aparelho
     */
    public String getModelo() {
        return this.modelo;
    }

    /**
     * @param novoModelo Novo modelo do aparelho
     */
    public void setModelo(String novoModelo) {
        this.modelo = novoModelo;
    }

    /**
     * @return Retorna a descrição do aparelho
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @param novaDesc Nova descrição do aparelho
     */
    public void setDescricao(String novaDesc) {
        this.descricao = novaDesc;
    }
}