package ecommerce2.servidor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ProdutoTest {
    Produto produto1;
    Produto produto2;

    @BeforeEach
    public void initialize(){
        produto1 = new Produto(1,"Casas Bahia","XBOX X","Novo Console da Microsoft",3000.00);
        produto2 = new Produto();
    }

    @Test
    public void shouldGetIdProduct(){
        Assertions.assertEquals(1,this.produto1.getIdProduto());
    }

    @Test
    public void shouldGetEcommerceName(){
        Assertions.assertEquals("Casas Bahia",this.produto1.getEcommerceProduto());
    }

    @Test
    public void shouldGetNameProduct(){
        Assertions.assertEquals("XBOX X",this.produto1.getNomeProduto());
    }

    @Test
    public void shouldGetDescriptionProduct(){
        Assertions.assertEquals("Novo Console da Microsoft",this.produto1.getDescricaoProduto());
    }

    @Test
    public void shouldGetPriceProduct(){
        Assertions.assertEquals(3000.00,this.produto1.getPrecoProduto());
    }

    @Test
    public void shouldSetIdProduct(){
        this.produto2.setId(2);
        Assertions.assertEquals(2,this.produto2.getIdProduto());
    }

    @Test
    public void shouldSetEcommerceName(){
        this.produto2.setEcommerce("Ponto Frio");
        Assertions.assertEquals("Ponto Frio",this.produto2.getEcommerceProduto());
    }

    @Test
    public void shouldSetNameProduct(){
        this.produto2.setNomeProduto("Playstation 5");
        Assertions.assertEquals("Playstation 5", this.produto2.getNomeProduto());
    }

    @Test
    public void shouldSetDescriptionProduct(){
        this.produto2.setDescricao("Novo Console da Sony");
        Assertions.assertEquals("Novo Console da Sony",this.produto2.getDescricaoProduto());
    }

    @Test
    public void shouldSetPriceProduct(){
        this.produto2.setPrecoProduto(4000.00);
        Assertions.assertEquals(4000.00,this.produto2.getPrecoProduto());
    }
}