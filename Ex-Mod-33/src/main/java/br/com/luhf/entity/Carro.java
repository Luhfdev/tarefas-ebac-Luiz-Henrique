package main.java.br.com.luhf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;

    // Construtores

    public Carro() {
    }

    public Carro(String nome, Marca marca, int ano, double preco) {
        this.nome = nome;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
        this.acessorios = acessorios;
    }

    // Getters e Setters

    public Long getCodigo() {
        return id;
    }

    public void setCodigo(Long codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "codigo=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", preco=" + preco +
                ", marca=" + marca +
                ", acessorios=" + acessorios +
                '}';
    }
}
