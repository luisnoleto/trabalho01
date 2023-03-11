package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Cobertura;

public class CoberturaResponseDTO {

    private Long id;
    private String coberturas;
    private Map<String, Object> sorvete;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCoberturas() {
        return coberturas;
    }
    public void setCoberturas(String coberturas) {
        this.coberturas = coberturas;
    }
    public Map<String, Object> getSorvete() {
        return sorvete;
    }
    public void setSorvete(Map<String, Object> sorvete) {
        this.sorvete = sorvete;
    }
    
    public CoberturaResponseDTO(Cobertura cobertura) {
        this.id = cobertura.getId();
        this.coberturas = cobertura.getCoberturas();
        this.sorvete = new HashMap<String, Object>();
        this.sorvete.put("id", cobertura.getSorvete().getId());
        this.sorvete.put("sabores", cobertura.getSorvete().getSabores());
        this.sorvete.put("precosabor", cobertura.getSorvete().getPrecosabor());
    }
        
}
