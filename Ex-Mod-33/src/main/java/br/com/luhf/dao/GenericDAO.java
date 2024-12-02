package main.java.br.com.luhf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class GenericDAO<T> {

    private EntityManager entityManager;
    private Class<T> entityClass;

    public GenericDAO(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    // Salva uma nova entidade no banco de dados
    public void salvar(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    // Busca uma entidade pelo ID
    public T buscarPorId(Long id) {
        return entityManager.find(entityClass, id);
    }

    // Busca todas as entidades da tabela
    public List<T> buscarTodos() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    // Atualiza uma entidade no banco de dados
    public void atualizar(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    // Exclui uma entidade do banco de dados
    public void excluir(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entity = entityManager.merge(entity); // Garante que a entidade está gerenciada
            entityManager.remove(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}