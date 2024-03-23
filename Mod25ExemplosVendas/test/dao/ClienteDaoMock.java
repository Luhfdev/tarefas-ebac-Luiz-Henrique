package dao;

import br.com.luhf.dao.IClienteDao;
import br.com.luhf.domain.Cliente;
import br.com.luhf.exception.TipoChaveNaoEncontradaException;
import java.util.Collection;

public class ClienteDaoMock implements IClienteDao {

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
