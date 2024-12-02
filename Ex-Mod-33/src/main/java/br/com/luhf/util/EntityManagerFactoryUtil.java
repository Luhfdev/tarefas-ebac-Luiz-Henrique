package main.java.br.com.luhf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        // A unidade de persistência "carro_persistence_unit" deve ser definida no persistence.xml
        entityManagerFactory = Persistence.createEntityManagerFactory("carro_persistence_unit");
    }

    // Método para obter uma instância do EntityManager
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para fechar o EntityManagerFactory (deve ser chamado ao final da aplicação)
    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}

