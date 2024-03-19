package br.com.luhf.Stream;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String id;

    private String nome;

    private String nacionalidade;

    private int idade;


    public Pessoa() {

    }

    public Pessoa(String id, String nome, String nacionalidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Pessoa> populaPessoas(){
        Pessoa pessoa1 = new Pessoa("p1", "João", "Brasil", 18);
        Pessoa pessoa2 = new Pessoa("p2", "Maria", "Mexico", 56);
        Pessoa pessoa3 = new Pessoa("p3", "Cleusa", "Inglaterra", 42);
        Pessoa pessoa4 = new Pessoa("p4", "Matheus", "França", 27);
        Pessoa pessoa5 = new Pessoa("p1", "João", "Brasil", 18);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idade=" + idade +
                '}';
    }
}
