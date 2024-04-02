package br.com.luhf.domain;

public class Produto {

    private Integer id;

    private String nome;

    private String codigo;

    private Double valor;

    private Integer quantidadeEstoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public double setValor(Double valor) {
        this.valor = valor;
        return 0;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        return 0;
    }
}
