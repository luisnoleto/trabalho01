package br.unitins.model;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Professor extends PanacheEntity {
    private String nome;
    private int idade;
    private String disciplina;
    public int matricula;
    public int anoinicio;


    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(int anoinicio) {
        this.anoinicio = anoinicio;
    }

    
}
