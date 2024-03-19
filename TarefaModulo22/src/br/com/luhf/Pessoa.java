package br.com.luhf;

import java.util.List;

public class Pessoa {

    private String nome;

    private String genero;

    private Integer idade;


    public Pessoa() {

    }

    public Pessoa(String nome, String genero, Integer idade) {
        this.nome = nome;
        this.genero = genero;
        this.idade = Integer.valueOf(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Pessoa> pessoas() {
        Pessoa pessoa1 = new Pessoa("João", "Homem", 18);
        Pessoa pessoa2 = new Pessoa("Maria", "Mulher", 20);
        Pessoa pessoa3 = new Pessoa("Augusta", "Mulher", 24);
        Pessoa pessoa4 = new Pessoa("Fernanda", "Mulher", 48);
        Pessoa pessoa5 = new Pessoa("Clovis", "Homem", 7);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                '}';
    }
}
