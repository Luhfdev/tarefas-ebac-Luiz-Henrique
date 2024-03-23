package br.com.luhf.dao;

import br.com.luhf.dao.generics.GenericDao;
import br.com.luhf.domain.Cliente;

public class ClienteDao extends GenericDao<Cliente> implements IClienteDao {

    public ClienteDao(){
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
