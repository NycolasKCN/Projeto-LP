package br.ufpb.nycolas.sistema;

import java.text.Format;

public class Aparelho {
    private int id;
    private String marca;
    private String modelo;
    private String descricao;

    /**
     * Construtor com todos os paramentros
     * 
     * @param id        Id do aparelho
     * @param marca     Marca do aparelho
     * @param modelo    Modelo do aparelho
     * @param descrição Breve descrição do aparelho
     */
    public Aparelho(int id, String marca, String modelo, String descrição) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descrição;
    }

    /**
     * Construtor padrão sem parametros
     */
    public Aparelho() {
        this(0, "", "", "");
    }

    @Override
    public String toString() {
        String s = String.format("%d ; %s ; %s ; %s", this.id, this.marca, this.modelo, this.descricao);
        return s;
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