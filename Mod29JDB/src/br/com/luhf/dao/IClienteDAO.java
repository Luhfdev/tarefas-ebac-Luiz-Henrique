package br.com.luhf.dao;

import br.com.luhf.domain.Cliente;

import java.sql.SQLException;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo);
}
