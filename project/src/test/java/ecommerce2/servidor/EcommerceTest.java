package ecommerce2.servidor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class EcommerceTest {
    Ecommerce ecommerce1;
    Ecommerce ecommerce2;
    Pedido pedido1;
    Produto produto1;
    Produto produto2;
    Produto produto3;

    @BeforeEach
    public void initialize(){
        this.ecommerce1 = new Ecommerce(1,"Lojas Americanas");
        this.ecommerce2 = new Ecommerce();
        this.pedido1 = new Pedido(1,"Lojas Americanas","Gabriel Fanto","Em Andamento",25,"02/02/2020");
        this.produto1 = new Produto(1,"Lojas Americanas","XBOX X","Novo XBOX",2000.00);
        this.produto2 = new Produto(2,"Lojas Americanas","PS4","Playstation 4",1000.00);
        this.produto3 = new Produto(3,"Ponto Frio","WII","novo Wii",300.00);
    }

    @Test
    public void shouldGetIdEcommerce(){
        Assertions.assertEquals(1,this.ecommerce1.getIdEcommerce());
    }

    @Test
    public void shouldGetNomeEcommerce(){
        Assertions.assertEquals("Lojas Americanas",this.ecommerce1.getNomeEcommerce());
    }

    @Test
    public void shouldSetIdEcommerce(){
        this.ecommerce2.setIdEcommerce(2);
        Assertions.assertEquals(2,this.ecommerce2.getIdEcommerce());
    }

    @Test
    public void shouldSetNomeEcommerce(){
        this.ecommerce2.setNomeEcommerce("Ponto Frio");
        Assertions.assertEquals("Ponto Frio",this.ecommerce2.getNomeEcommerce());
    }

    @Test
    public void shouldAddEcommerceToDatabase(){
        //boolean added = this.ecommerce2.addEcommerceToDatabase(this.ecommerce1);
        //Assertions.assertTrue(added);
    }

    @Test
    public void shouldAddProductsToEcommerceDatabase(){
        boolean added1 = this.ecommerce1.addProdutosToDatabase(this.produto1,this.ecommerce1.getNomeEcommerce());
        boolean added2 = this.ecommerce1.addProdutosToDatabase(this.produto2,this.ecommerce1.getNomeEcommerce());
        Assertions.assertTrue(added1 && added2);
    }

    @Test
    public void shouldAddProductsToPedidoAndAddPedidoToEcommerce(){
        boolean addProduto1 = this.pedido1.addProduto(this.produto1);
        boolean addProduto2 = this.pedido1.addProduto(this.produto2);
        boolean addPedido1 = this.ecommerce1.addPedidosToDatabase(this.pedido1,this.ecommerce1.getNomeEcommerce());
        Assertions.assertTrue(addProduto1 && addProduto2 && addPedido1);
    }

    @Test
    public void shouldVisualizeEcommerceDatabase(){
        //boolean added1 = this.ecommerce2.addEcommerceToDatabase(this.ecommerce1);
        //this.ecommerce2.visualizeEcommerceDatabase();
       // Assertions.assertTrue(added1);
    }

    @Test
    public void shouldVisualizeTwoEcommerceDatabase(){
        this.ecommerce2.setIdEcommerce(2);
        this.ecommerce2.setNomeEcommerce("Ponto Frio");
        // Serve para ser um banco de dados
       // Ecommerce database = new Ecommerce();
       // database.addEcommerceToDatabase(this.ecommerce1);
        //database.addEcommerceToDatabase(this.ecommerce2);
       // database.visualizeEcommerceDatabase();
    }

    @Test
    public void shouldVisualizeTwoProdutosDatabase(){
        this.ecommerce2.setIdEcommerce(2);
        this.ecommerce2.setNomeEcommerce("Ponto Frio");
        //Ecommerce database = new Ecommerce();
       // boolean addedEco1 = database.addEcommerceToDatabase(this.ecommerce1);
      //  boolean addedEco2 = database.addEcommerceToDatabase(this.ecommerce2);
       // boolean addedProd1 = database.addProdutosToDatabase(this.produto1, this.produto1.getEcommerceProduto());
      //  boolean addedProd2 = database.addProdutosToDatabase(this.produto3, this.produto3.getEcommerceProduto());
       // database.visualizeProdutosDatabase();
       // Assertions.assertTrue(addedEco1 && addedEco2 && addedProd1 && addedProd2);
    }

    @Test
    public void shouldVisualizePedidosDatabase(){
        this.ecommerce1.addPedidosToDatabase(this.pedido1, this.ecommerce1.getNomeEcommerce());
    }
}