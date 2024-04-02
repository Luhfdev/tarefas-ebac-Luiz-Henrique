package br.com.luhf.dao;

import br.com.luhf.domain.Cliente;
import br.com.luhf.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws SQLException;

    Produto consultar(String codigo) throws SQLException;

    Integer excluir(Produto produtoDB) throws SQLException;

    void alterar(Produto produto, String nome, Double valor, Integer quant) throws SQLException;

    List<Produto> buscarTodos(List<Produto> produtos) throws SQLException;
}
