package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cobertura{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String coberturas;

    public String getCoberturas() {
        return coberturas;
    }
    public void setCoberturas(String coberturas) {
        this.coberturas = coberturas;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "id_sorvete")
    private Sorvete sorvete;

    public Sorvete getSorvete() {
        return sorvete;
    }
    public void setSorvete(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

}