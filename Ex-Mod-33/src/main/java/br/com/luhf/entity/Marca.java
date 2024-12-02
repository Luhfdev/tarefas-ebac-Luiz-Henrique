package main.java.br.com.luhf.entity;

import javax.persistence.*;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca(String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Marca() {

    }
}

