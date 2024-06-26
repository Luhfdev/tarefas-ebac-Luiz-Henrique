package br.com.luhf.dao;

import br.com.luhf.dao.jdbc.ConnectionFactory;
import br.com.luhf.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public Cliente consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNome(rs.getString("nome"));
            }
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public Integer excluir(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void alterar(Cliente cliente, String nome) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_CLIENTE SET NOME ? WHERE ID ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.setNome(nome));
            stm.setString(2, cliente.getCodigo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public List<Cliente> buscarTodos(List<Cliente> clientes) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE";
            stm = connection.prepareStatement(sql);
            return clientes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.isClosed();
            }
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        }
    }
}
