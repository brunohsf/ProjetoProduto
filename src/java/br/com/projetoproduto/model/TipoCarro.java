package br.com.projetoproduto.model;

public class TipoCarro {
    
    private Integer idTipoCarro;
    private String nomeTipoCarro;

    public TipoCarro() {
    }

    public TipoCarro(Integer idTipoCarro, String nomeTipoCarro) {
        this.idTipoCarro = idTipoCarro;
        this.nomeTipoCarro = nomeTipoCarro;
    }

    public Integer getIdTipoCarro() {
        return idTipoCarro;
    }

    public void setIdTipoCarro(Integer idTipoCarro) {
        this.idTipoCarro = idTipoCarro;
    }

    public String getNomeTipoCarro() {
        return nomeTipoCarro;
    }

    public void setNomeTipoCarro(String nomeTipoCarro) {
        this.nomeTipoCarro = nomeTipoCarro;
    }
    
    
    
    
}
