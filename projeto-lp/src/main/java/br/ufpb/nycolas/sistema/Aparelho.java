package br.ufpb.nycolas.sistema;

public class Aparelho {
    // TODO documentar todas as funções
    private String id;
    private String marca;
    private String modelo;
    private String proprietario;

    /**
     * Construtor com todos os paramentros
     * 
     * @param id        Id do aparelho
     * @param marca     Marca do aparelho
     * @param modelo    Modelo do aparelho
     * @param descrição Breve descrição do aparelho
     */
    public Aparelho(String id, String marca, String modelo, String proprietario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    /**
     * Construtuor com apenas o id como parametro
     * 
     * @param id id do Aparelho
     */
    public Aparelho(String id) {
        this(id, "vazio", "vazio", "vazio");
    }

    public Aparelho(String marca, String modelo, String descrição) {
        this("0", marca, modelo, descrição);
    }

    /**
     * Construtor padrão sem parametros
     */
    public Aparelho() {
        this("0", "vazio", "vazio", "vazio");
    }

    /**
     * Representação do aparelho em String
     * 
     * @return Retorna todos os atributos separados por ";"
     */
    @Override
    public String toString() {
        return this.id + ";" + this.marca + ";" + this.modelo + ";" + this.proprietario + ";";
    }

    /**
     * @return retorna o id do aparelho
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param novoId Novo id do aparelho
     */
    public void setId(String novoId) {
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

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aparelho other = (Aparelho) obj;
        if (proprietario == null) {
            if (other.proprietario != null)
                return false;
        } else if (!proprietario.equals(other.proprietario))
            return false;
        return true;
    }
}