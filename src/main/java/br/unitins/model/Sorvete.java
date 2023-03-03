package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sorvete{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String sabores;

    @Column(length = 4, nullable = false)
    private String precosabor;
    

    public String getSabores() {
        return sabores;
    }
    
    public void setSabores(String sabores) {
        this.sabores = sabores;
    }

    public String getPrecosabor() {
        return precosabor;
    }

    public void setPrecosabor(String precosabor) {
        this.precosabor = precosabor;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}