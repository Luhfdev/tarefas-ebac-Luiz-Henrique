package br.com.luhf;

import br.com.luhf.domain.Cliente;
import br.com.luhf.exception.TipoChaveNaoEncontradaException;
import br.com.luhf.services.ClienteServiceMock;
import br.com.luhf.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        clienteService = new ClienteServiceMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Luiz");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(119999999L);
        clienteService.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Lulu");
        clienteService.alterar(cliente);

        Assert.assertEquals("Lulu", cliente.getNome());
    }
}
