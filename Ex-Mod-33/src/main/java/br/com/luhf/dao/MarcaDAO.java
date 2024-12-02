package main.java.br.com.luhf.dao;

import main.java.br.com.luhf.entity.Marca;
import main.java.br.com.luhf.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MarcaDAO {

    private EntityManager entityManager;

    public MarcaDAO() {
        this.entityManager = EntityManagerFactoryUtil.getEntityManager();
    }

    public void salvar(Marca marca) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(marca);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}


