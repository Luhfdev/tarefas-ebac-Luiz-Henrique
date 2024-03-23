package br.com.luhf.services.generics;

import br.com.luhf.domain.Persistente;
import br.com.luhf.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IGenericSerices <T extends Persistente>{
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(Long valor);

    public Collection<T> buscarTodos();
}
