package br.com.projetoproduto.model;

public class Carro extends Produto{
    
    private Integer idCarro;
    private Integer anoCarro;
    private Integer modeloCarro;
    private Integer nrportasCarro;

    public Carro() {
    }

    public Carro(Integer idCarro, Integer anoCarro, Integer modeloCarro, Integer nrportasCarro) {
        this.idCarro = idCarro;
        this.anoCarro = anoCarro;
        this.modeloCarro = modeloCarro;
        this.nrportasCarro = nrportasCarro;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public Integer getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(Integer anoCarro) {
        this.anoCarro = anoCarro;
    }

    public Integer getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(Integer modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Integer getNrportasCarro() {
        return nrportasCarro;
    }

    public void setNrportasCarro(Integer nrportasCarro) {
        this.nrportasCarro = nrportasCarro;
    }
    
}
