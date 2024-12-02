package main.java.br.com.luhf.main;

import main.java.br.com.luhf.dao.GenericDAO;
import main.java.br.com.luhf.entity.Acessorio;
import main.java.br.com.luhf.entity.Carro;
import main.java.br.com.luhf.entity.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-pu");
        EntityManager em = emf.createEntityManager();

        GenericDAO<Carro> carroDAO = new GenericDAO<>(em, Carro.class);
        GenericDAO<Marca> marcaDAO = new GenericDAO<>(em, Marca.class);
        GenericDAO<Acessorio> acessorioDAO = new GenericDAO<>(em, Acessorio.class);

        // Exemplo: Adicionando uma marca
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marcaDAO.salvar(marca);

        // Exemplo: Adicionando um acessório
        Acessorio acessorio = new Acessorio("Ar condicionado");
        acessorio.setNome("Ar Condicionado");
        acessorioDAO.salvar(acessorio);

        // Exemplo: Adicionando um carro
        Carro carro = new Carro();
        carro.setNome("Corolla");
        carro.setAno(2022);
        carro.setMarca(marca);
        carro.setAcessorios(List.of(acessorio));
        carroDAO.salvar(carro);

        em.close();
        emf.close();
    }
}

