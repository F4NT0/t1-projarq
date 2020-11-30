package ecommerce2.servidor;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PedidoTest {
    Pedido pedido1;
    Pedido pedido2;
    Pedido pedido4;
    Produto produto1;
    Produto produto2;
    Produto produto3;
    
    @BeforeEach
    public void initialize(){
        pedido2= new Pedido();
        pedido1 = new Pedido(1,"Apple","Gabriel Fanto","Em Andamento",25,"02/02/2020");
        produto1 = new Produto(1,"Apple","Macbook Pro S","Mais um Macbook",2500.00);
        produto2 = new Produto(2,"Apple","Iphone S","Mais um Iphone",3000.00);
        produto3 = new Produto(3,"Apple","Ipods","Mais um Ipod",300.00);
    }

    @Test
    public void shouldGetId(){
        Assertions.assertEquals(1,this.pedido1.getIdPedido());
    }

    @Test
    public void shouldGetEcommerceName(){
        Assertions.assertEquals("Apple",this.pedido1.getNomeEcommerce());
    }
    
    @Test
    public void shouldGetNameClient(){
        Assertions.assertEquals("Gabriel Fanto",this.pedido1.getNomeCliente());
    }

    @Test
    public void shouldGetStatus(){
        Assertions.assertEquals("Em Andamento",this.pedido1.getStatus());
    }

    @Test
    public void shouldGetMaxTimeDelivered(){
        Assertions.assertEquals(25,this.pedido1.getPrazoMaximoEntrega());
    }

    @Test
    public void shouldGetData(){
        Assertions.assertEquals("02/02/2020",this.pedido1.getData());
    }

    @Test
    public void shouldAddProductToList(){
        boolean add1 = this.pedido1.addProduto(this.produto1);
        boolean add2 = this.pedido1.addProduto(this.produto2);
        boolean add3 = this.pedido1.addProduto(this.produto3);
        Assertions.assertTrue(add1 && add2 && add3);
    }

    @Test
    public void shouldGetProductList(){
        this.pedido1.addProduto(this.produto1);
        this.pedido1.addProduto(this.produto2);
        this.pedido1.addProduto(this.produto3);
        ArrayList<Produto> aux = this.pedido1.getListaProdutos();
        for(Produto valor : aux){
            System.out.println("\n");
            System.out.println("ID do Produto: " + valor.getIdProduto());
            System.out.println("Nome do Ecommerce: " + valor.getEcommerceProduto());
            System.out.println("Nome do Produto: " + valor.getNomeProduto());
            System.out.println("Descricao do Produto: " + valor.getDescricaoProduto());
            System.out.println("Preco do Produto: " + valor.getPrecoProduto());
        }
        Assertions.assertTrue(true);
    }

    @Test
    public void shouldRemoveProduct(){
        this.pedido1.addProduto(this.produto1);
        this.pedido1.addProduto(this.produto2);
        this.pedido1.addProduto(this.produto3);
        ArrayList<Produto> aux = this.pedido1.getListaProdutos();
        System.out.println("\nNro de Produtos na Lista de Produtos: " + aux.size());
        boolean remove1 = this.pedido1.removeProduto(this.produto1);
        Assertions.assertTrue(remove1);
    }
}