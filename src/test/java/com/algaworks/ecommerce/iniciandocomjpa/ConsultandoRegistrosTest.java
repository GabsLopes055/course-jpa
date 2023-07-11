package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultandoRegistrosTest {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void  buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);

    }

    @Test
    public void atualizaReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setNome("Testando a mudança do nome");

        System.out.println(produto.getNome());

    }

}
