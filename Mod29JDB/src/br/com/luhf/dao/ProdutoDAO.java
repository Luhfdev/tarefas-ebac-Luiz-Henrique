package br.com.luhf.dao;

import br.com.luhf.dao.jdbc.ConnectionFactory;
import br.com.luhf.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{

    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID_PRODUTO, CODIGO_PRODUTO, NOME_PRODUTO, VALOR, QUANTIDADE_ESTOQUE) VALUES(nextval('SQ_PRODUTO'),?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setDouble(3, produto.getValor());
            stm.setInt(4, produto.getQuantidadeEstoque());
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
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO_PRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId((int) rs.getLong("id_produto"));
                produto.setCodigo(rs.getString("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setValor(rs.getDouble("valor"));
                produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
            }
            return produto;
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
    public Integer excluir(Produto produtoDB) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO_PRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produtoDB.getCodigo());
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
    public void alterar(Produto produto, String nome, Double valor, Integer quant) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO SET NOME_PRODUTO ? , VALOR ? , QUANTIDADE_ESTOQUE ? WHERE ID ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.setNome(nome));
            stm.setDouble(2, produto.setValor(valor));
            stm.setInt(3, produto.setQuantidadeEstoque(quant));
            stm.setString(4, produto.getCodigo());
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
    public List<Produto> buscarTodos(List<Produto> produtos) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stm = connection.prepareStatement(sql);
            return produtos;
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
