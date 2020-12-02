package ecommerce2.servidor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClienteTest {
    Cliente clienteTest1;
    Cliente clienteTest2;
    Cliente clienteTest3;

    @BeforeEach
    public void initialize(){
        //clienteTest1 = new Cliente(1,"Gabriel Fanto",12345678);
        clienteTest1=Cliente.getInstance();
        clienteTest1.setId(1);
        clienteTest1.setNome("Gabriel Fanto");
        clienteTest1.setCpf(12345678);
        clienteTest2= Cliente.getInstance();
        //clienteTest2 = new Cliente();
        //clienteTest3 = new Cliente();
    }

    @Test
    public void shouldGetName(){
        Assertions.assertEquals("Gabriel Fanto",this.clienteTest1.getNome());
    }

    @Test
    public void shouldGetCpf(){
        Assertions.assertEquals(12345678,this.clienteTest1.getCpf());
    }

    @Test
    public void shouldGetIdClient(){
        Assertions.assertEquals(1,this.clienteTest1.getIdCliente());
    }

    @Test
    public void shouldSetName(){
        String newName = "Felipe Tavares";
        this.clienteTest2.setNome(newName);
        Assertions.assertEquals("Felipe Tavares",this.clienteTest2.getNome());
    }

    @Test
    public void shouldSetCpf(){
        int newCpf = 87654321;
        this.clienteTest2.setCpf(newCpf);
        Assertions.assertEquals(87654321,this.clienteTest2.getCpf());
    }

    @Test
    public void shouldSetId(){
        int newId = 2;
        this.clienteTest2.setId(newId);
        Assertions.assertEquals(2,this.clienteTest2.getIdCliente());
    }

    @Test
    public void shouldAddClientToDatabase(){
        this.clienteTest2.setNome("Felipe Tavares");
        this.clienteTest2.setCpf(87654321);
        this.clienteTest2.setId(2);
        boolean add1 = this.clienteTest3.clienteDatabase(this.clienteTest1);
        boolean add2 = this.clienteTest3.clienteDatabase(this.clienteTest2);
        this.clienteTest3.getDatabase();
        Assertions.assertTrue(add1 && add2);
    }

    @Test
    public void shouldCheckLoginClient1(){
        boolean add1 = this.clienteTest3.clienteDatabase(this.clienteTest1);
        boolean result = this.clienteTest3.checkLogin("Gabriel Fanto", 12345678);
        Assertions.assertTrue(add1 && result);
    }

    @Test
    public void shouldCheckLoginClient2(){
        this.clienteTest2.setNome("Felipe Tavares");
        this.clienteTest2.setCpf(87654321);
        this.clienteTest2.setId(2);
        boolean add2 = this.clienteTest3.clienteDatabase(this.clienteTest2);
        boolean result = this.clienteTest3.checkLogin("Felipe Tavares", 87654321);
        Assertions.assertTrue(add2 && result);
    }

    @Test
    public void shoulCheckLoginFalse(){
        boolean result = this.clienteTest3.checkLogin("BLABLABLA", 1234);
        Assertions.assertFalse(result);
    }

}