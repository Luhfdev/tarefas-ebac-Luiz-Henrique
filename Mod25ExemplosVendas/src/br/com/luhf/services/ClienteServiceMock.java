package br.com.luhf.services;

import br.com.luhf.domain.Cliente;
import br.com.luhf.exception.TipoChaveNaoEncontradaException;
import br.com.luhf.services.IClienteService;

import java.util.Collection;

public class ClienteServiceMock implements IClienteService {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
