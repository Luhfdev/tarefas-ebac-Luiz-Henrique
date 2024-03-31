package br.com.luhf;

import br.com.luhf.dao.ClienteDAO;
import br.com.luhf.dao.IClienteDAO;
import br.com.luhf.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Luiz Henrique");

        Integer qtd = dao.cadastrar(null);
        Assert.assertEquals(1, (int) qtd);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
    }
}
