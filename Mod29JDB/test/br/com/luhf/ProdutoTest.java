package br.com.luhf;

import br.com.luhf.dao.ClienteDAO;
import br.com.luhf.dao.IClienteDAO;
import br.com.luhf.dao.IProdutoDAO;
import br.com.luhf.dao.ProdutoDAO;
import br.com.luhf.domain.Cliente;
import br.com.luhf.domain.Produto;
import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTest {

    @Test
    public void cadastrarPTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Laranja");
        produto.setValor(25.00);
        produto.setQuantidadeEstoque(5);

        Integer qtd = dao.cadastrar(produto);
        Assert.assertEquals(1, (int) qtd);

        dao.excluir(produto);
    }

    @Test
    public void excluirPTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Cuzcuz");
        produto.setValor(25.00);
        produto.setQuantidadeEstoque(5);

        dao.cadastrar(produto);

        Integer del = dao.excluir(produto);
        Assert.assertNotNull(del);
    }

    @Test
    public void consultarPTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Banana");
        produto.setValor(25.00);
        produto.setQuantidadeEstoque(5);

        dao.cadastrar(produto);

        Produto produtoDB = dao.consultar(produto.getCodigo());
        Assert.assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        Assert.assertEquals(produto.getNome(), produtoDB.getNome());
        System.out.println(produtoDB.getNome());

        dao.excluir(produtoDB);
    }

    @Test
    public void alterarPTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Arroz");
        produto.setValor(25.00);
        produto.setQuantidadeEstoque(5);

        dao.cadastrar(produto);

        dao.alterar(produto, "Batata", 18.00, 8);
        Assert.assertEquals("Batata", produto.getNome());
    }

    @Test
    public void BuscarTodosPTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Arroz");
        produto.setValor(25.00);
        produto.setQuantidadeEstoque(5);
        dao.cadastrar(produto);

        Produto produto2 = new Produto();
        produto2.setCodigo("02");
        produto2.setNome("Jabuticaba");
        produto2.setValor(25.00);
        produto2.setQuantidadeEstoque(5);
        dao.cadastrar(produto2);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);

        List<Produto> qtd = dao.buscarTodos(produtos);
        Assert.assertEquals(2, qtd.size());

        dao.excluir(produto);
        dao.excluir(produto2);
    }
}
