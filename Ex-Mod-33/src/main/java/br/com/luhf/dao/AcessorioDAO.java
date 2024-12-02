package main.java.br.com.luhf.dao;

import main.java.br.com.luhf.entity.Acessorio;
import main.java.br.com.luhf.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AcessorioDAO {

    private EntityManager entityManager;

    public AcessorioDAO() {
        this.entityManager = EntityManagerFactoryUtil.getEntityManager();
    }

    public void salvar(Acessorio acessorio) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(acessorio);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
