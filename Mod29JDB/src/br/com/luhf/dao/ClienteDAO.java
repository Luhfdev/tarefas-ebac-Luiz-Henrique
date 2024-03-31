package br.com.luhf.dao;

import br.com.luhf.dao.jdbc.ConnectionFactory;
import br.com.luhf.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES(nextval('SQ_CLIENTE'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.isClosed();
            }
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        }
    }

    @Override
    public Cliente consultar(String codigo) {
        return null;
    }
}
