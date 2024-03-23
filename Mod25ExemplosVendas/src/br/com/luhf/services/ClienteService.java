package br.com.luhf.services;

import br.com.luhf.dao.IClienteDao;
import br.com.luhf.domain.Cliente;
import br.com.luhf.services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService{

    public ClienteService(IClienteDao dao){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
