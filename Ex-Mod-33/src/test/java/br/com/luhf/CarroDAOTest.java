package test.java.br.com.luhf;


import main.java.br.com.luhf.dao.AcessorioDAO;
import main.java.br.com.luhf.dao.CarroDAO;
import main.java.br.com.luhf.dao.MarcaDAO;
import main.java.br.com.luhf.entity.Acessorio;
import main.java.br.com.luhf.entity.Carro;
import main.java.br.com.luhf.entity.Marca;
import main.java.br.com.luhf.util.EntityManagerFactoryUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CarroDAOTest {

    private CarroDAO carroDAO;
    private MarcaDAO marcaDAO;
    private AcessorioDAO acessorioDAO;
    private EntityManager entityManager;

    @Before
    public void setUp() {
        // Inicializa os DAOs e o EntityManager antes de cada teste
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
        entityManager = EntityManagerFactoryUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        // Fecha o EntityManager após o teste
        if (entityManager.isOpen()) {
            entityManager.close();
        }
        EntityManagerFactoryUtil.close();
    }

    @Test
    public void testSalvarCarro() {
        // Cria uma marca
        Marca marca = new Marca("Volkswagen");
        marcaDAO.salvar(marca);

        // Cria acessórios
        Acessorio acessorio1 = new Acessorio("Ar condicionado");
        Acessorio acessorio2 = new Acessorio("Direção hidráulica");
        acessorioDAO.salvar(acessorio1);
        acessorioDAO.salvar(acessorio2);

        // Cria um carro com a marca e acessórios
        Carro carro = new Carro("Fusca", marca, 1975, 10000.00);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));

        // Salva o carro no banco de dados
        carroDAO.salvar(carro);

        // Verifica se o carro foi persistido corretamente
        Carro carroBuscado = entityManager.find(Carro.class, carro.getCodigo());

        assertNotNull("O carro deve ter sido salvo no banco de dados.", carroBuscado);
        assertEquals("O nome do carro não corresponde.", "Fusca", carroBuscado.getNome());
        assertEquals("A marca do carro não corresponde.", "Volkswagen", carroBuscado.getMarca().getNome());
        assertEquals("O ano do carro não corresponde.", 1975, carroBuscado.getAno());
        assertEquals("O preço do carro não corresponde.", 10000.00, carroBuscado.getPreco(), 0.01);
        assertEquals("O carro deve ter 2 acessórios.", 2, carroBuscado.getAcessorios().size());
    }

    @Test
    public void testExcluirCarro() {
        // Cria uma marca
        Marca marca = new Marca("Chevrolet");
        marcaDAO.salvar(marca);

        // Cria acessórios
        Acessorio acessorio1 = new Acessorio("Ar condicionado");
        Acessorio acessorio2 = new Acessorio("Direção hidráulica");
        acessorioDAO.salvar(acessorio1);
        acessorioDAO.salvar(acessorio2);

        // Cria e salva o carro
        Carro carro = new Carro("Chevette", marca, 1980, 8000.00);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));
        carroDAO.salvar(carro);

        // Exclui o carro
        carroDAO.excluir(carro);

        // Verifica se o carro foi excluído corretamente
        Carro carroBuscado = entityManager.find(Carro.class, carro.getCodigo());

        assertNull("O carro deve ser excluído do banco de dados.", carroBuscado);
    }

    @Test
    public void testAtualizarCarro() {
        // Cria uma marca
        Marca marca = new Marca("Fiat");
        marcaDAO.salvar(marca);

        // Cria acessórios
        Acessorio acessorio1 = new Acessorio("Ar condicionado");
        Acessorio acessorio2 = new Acessorio("Direção hidráulica");
        acessorioDAO.salvar(acessorio1);
        acessorioDAO.salvar(acessorio2);

        // Cria e salva o carro
        Carro carro = new Carro("Palio", marca, 2000, 15000.00);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));
        carroDAO.salvar(carro);

        // Atualiza os dados do carro
        carro.setNome("Palio G5");
        carro.setPreco(18000.00);
        carroDAO.atualizar(carro);

        // Verifica se os dados do carro foram atualizados corretamente
        Carro carroBuscado = entityManager.find(Carro.class, carro.getCodigo());

        assertEquals("O nome do carro não foi atualizado.", "Palio G5", carroBuscado.getNome());
        assertEquals("O preço do carro não foi atualizado.", 18000.00, carroBuscado.getPreco(), 0.01);
    }

    @Test
    public void testBuscarCarros() {
        // Cria marcas
        Marca marca1 = new Marca("Honda");
        Marca marca2 = new Marca("Toyota");
        marcaDAO.salvar(marca1);
        marcaDAO.salvar(marca2);

        // Cria acessórios
        Acessorio acessorio1 = new Acessorio("Ar condicionado");
        Acessorio acessorio2 = new Acessorio("Direção hidráulica");
        acessorioDAO.salvar(acessorio1);
        acessorioDAO.salvar(acessorio2);

        // Cria e salva carros
        Carro carro1 = new Carro("Civic", marca1, 2015, 45000.00);
        carro1.setAcessorios(Arrays.asList(acessorio1, acessorio2));
        carroDAO.salvar(carro1);

        Carro carro2 = new Carro("Corolla", marca2, 2017, 50000.00);
        carro2.setAcessorios(Arrays.asList(acessorio1));
        carroDAO.salvar(carro2);

        // Busca todos os carros
        List<Carro> carros = carroDAO.buscarTodos();

        assertNotNull("A lista de carros não deve ser nula.", carros);
        assertTrue("A lista de carros deve conter pelo menos 2 carros.", carros.size() >= 2);
    }

    @Test
    public void testBuscarCarroPorId() {
        // Cria uma marca
        Marca marca = new Marca("Ford");
        marcaDAO.salvar(marca);

        // Cria acessórios
        Acessorio acessorio1 = new Acessorio("Ar condicionado");
        Acessorio acessorio2 = new Acessorio("Direção hidráulica");
        acessorioDAO.salvar(acessorio1);
        acessorioDAO.salvar(acessorio2);

        // Cria e salva o carro
        Carro carro = new Carro("Fusion", marca, 2010, 30000.00);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));
        carroDAO.salvar(carro);

        // Busca o carro pelo código
        Carro carroBuscado = carroDAO.buscarPorId(carro.getCodigo());

        assertNotNull("O carro deve ser encontrado pelo ID.", carroBuscado);
        assertEquals("O nome do carro não corresponde ao esperado.", "Fusion", carroBuscado.getNome());
    }
}
