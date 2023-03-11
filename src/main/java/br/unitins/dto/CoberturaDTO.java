package br.unitins.dto;


public class CoberturaDTO {
    private Long idSorvete;
    private String coberturas;

    public String getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(String coberturas) {
        this.coberturas = coberturas;
    }

    public Long getIdSorvete() {
        return idSorvete;
    }

    public void setIdSorvete(Long idSorvete) {
        this.idSorvete = idSorvete;
    }
}