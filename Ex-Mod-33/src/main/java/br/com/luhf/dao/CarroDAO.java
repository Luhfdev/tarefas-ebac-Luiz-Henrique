package main.java.br.com.luhf.dao;

import main.java.br.com.luhf.entity.Carro;
import main.java.br.com.luhf.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarroDAO {

    private EntityManager entityManager;

    public CarroDAO() {
        this.entityManager = EntityManagerFactoryUtil.getEntityManager();
    }

    public void salvar(Carro carro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(carro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void excluir(Carro carro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(carro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void atualizar(Carro carro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(carro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Carro> buscarTodos() {
        return entityManager.createQuery("FROM Carro", Carro.class).getResultList();
    }

    public Carro buscarPorId(Long id) {
        return entityManager.find(Carro.class, id);
    }
}
