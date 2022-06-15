package br.ufpb.nycolas.sistema;

public class OrdemDeServico {

    // TODO documentar todas as funções

    private String id;
    private String status;
    private String descricaoProblema;
    private Aparelho aparelhoVinculado;
    private Funcionario funcionarioResponsavel;

    public OrdemDeServico(String id, String status, String descricao, Aparelho aparelhoVinculado, Funcionario funcionarioResponsavel) {
        this.id = id;
        this.status = status;
        this.descricaoProblema = descricao;
        this.aparelhoVinculado = aparelhoVinculado;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    /**
     * Construtor padrão, nenhum parametro
     */
    public OrdemDeServico() {
        this("0", "vazio", "vazio", new Aparelho(), new Funcionario());
    }

    /**
     * Construtor padrão, nenhum parametro
     */
    public OrdemDeServico(String status, String descricao, Aparelho ap, Funcionario fu){
        this("0",status, descricao, ap, fu);
    } 

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        OrdemDeServico other = (OrdemDeServico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * Representação da ordem de serviço em String
     * 
     * @return Retorna todos os atributos separados por ";"
     */
    @Override
    public String toString() {
        return this.id + ";" + this.status + ";" + this.descricaoProblema + ";" + this.aparelhoVinculado.getId() + ";"
                + this.funcionarioResponsavel.getId() + ";";
    }

    /**
     * @return Retorna o id dessa OS
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param novoId Novo id para essa OS
     */
    public void setId(String novoId) {
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

    /**
     * @return Retorna o aparelho Vinculado a está os
     */
    public Aparelho getAparelhoVinculado() {
        return aparelhoVinculado;
    }

    /**
     * @param aparelhoVinculado Novo Aparelho vinculado a OS
     */
    public void setAparelhoVinculado(Aparelho aparelhoVinculado) {
        this.aparelhoVinculado = aparelhoVinculado;
    }

    /**
     * @return Retorna o Funcionario responsavel pela os
     */
    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    /**
     * @param funcionarioResponsavel Novo funcionario responsavel pela OS
     */
    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }
}