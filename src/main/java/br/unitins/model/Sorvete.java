package br.unitins.model;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Sorvete extends PanacheEntity {

    //@Id
    //private Integer id;
    
    private String sabores;
    private float precosabor;

    public String getSabores() {
        return sabores;
    }
    
    public void setSabores(String sabores) {
        this.sabores = sabores;
    }

    public float getPrecosabor() {
        return precosabor;
    }

    public void setPrecosabor(float precosabor) {
        this.precosabor = precosabor;
    }
}