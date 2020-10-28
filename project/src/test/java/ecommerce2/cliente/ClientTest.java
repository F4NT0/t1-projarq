package ecommerce2.cliente;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClientTest {
    Client cliente;

    @BeforeEach
    public void initialize(){
        this.cliente = new Client();
    }

    @Test
    public void shouldReturnVincularOptions(){
        String input = "vincular";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("vincular", this.cliente.options()); 
    }
    
    @Test
    public void shouldReturnProdutosOptions(){
        String input = "produtos";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("produtos", this.cliente.options());
    }

    @Test
    public void shouldReturnPedidosOptions(){
        String input = "pedidos";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("pedidos", this.cliente.options());
    }

    @Test
    public void shouldReturnSairOptions(){
        String input = "sair";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("sair", this.cliente.options());
    }

    @Test
    public void shouldReturnProdutosOptions2(){
        String input = "produtos";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("produtos", this.cliente.options2());   
    }

    @Test
    public void shouldReturnPedidosOptions2(){
        String input = "pedidos";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("pedidos", this.cliente.options2());
    }

    @Test
    public void shouldReturnVincularOptions2(){
        String input = "vincular";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("vincular", this.cliente.options2());
    }

    @Test
    public void shouldReturnSairOptions2(){
        String input = "sair";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("sair", this.cliente.options2());
    }

    @Test
    public void shouldReturnStringOptions3(){
        String ecommerce = "Apple";
        String result = this.cliente.options3(ecommerce);
        Assertions.assertEquals("ped:Apple:1:Fulano:Ativo:35:02/02/2020",result);
    }

    @Test
    public void shouldStartClient(){
        this.cliente.clientConnection();
    }

}