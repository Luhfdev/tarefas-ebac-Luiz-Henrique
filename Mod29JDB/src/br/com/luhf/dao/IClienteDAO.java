package br.com.luhf.dao;

import br.com.luhf.domain.Cliente;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente clienteBD) throws SQLException;

    void alterar(Cliente cliente, String nome) throws SQLException;

    List<Cliente> buscarTodos(List<Cliente> clientes) throws SQLException;
}