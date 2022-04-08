package br.com.projetoproduto.model;

public class Produto {
    
    private Integer idProduto;
    private String descProduto;
    private String marcaProduto;
    private String modeloProduto;
    private Double valorProduto;

    public Produto() {
    }

    public Produto(Integer idProduto, String descProduto, String marcaProduto, String modeloProduto, Double valorProduto) {
        this.idProduto = idProduto;
        this.descProduto = descProduto;
        this.marcaProduto = marcaProduto;
        this.modeloProduto = modeloProduto;
        this.valorProduto = valorProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

}
