package br.com.luhf;

import br.com.luhf.dao.ClienteDAO;
import br.com.luhf.dao.IClienteDAO;
import br.com.luhf.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");

        Integer qtd = dao.cadastrar(cliente);
        Assert.assertEquals(1, (int) qtd);

        dao.excluir(cliente);
    }

    @Test
    public void excluirTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");

        dao.cadastrar(cliente);

        Integer del = dao.excluir(cliente);
        Assert.assertNotNull(del);
    }

    @Test
    public void consultarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");

        dao.cadastrar(cliente);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
        System.out.println(clienteBD.getNome());
        dao.excluir(clienteBD);
    }

    @Test
    public void alterarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");

        dao.cadastrar(cliente);

        dao.alterar(cliente, "Jojo");
        Assert.assertEquals("Jojo", cliente.getNome());

        dao.excluir(cliente);
    }

    @Test
    public void buscarTodosTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");
        dao.cadastrar(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Jojo");
        dao.cadastrar(cliente2);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);

        List<Cliente> qtd = dao.buscarTodos(clientes);
        Assert.assertEquals(2, qtd.size());

        dao.excluir(cliente);
        dao.excluir(cliente2);
    }
}
