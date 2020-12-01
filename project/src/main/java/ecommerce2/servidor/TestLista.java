package ecommerce2.servidor;

import java.util.ArrayList;
import java.util.Observable;

public class TestLista{
    public static void main(String[] args){
        Ecommerce netShoes = new Ecommerce(0,"NetShoes");
        Ecommerce amazon = new Ecommerce(1,"Amazon");
        ListaEcommerces ecommerces = new ListaEcommerces();
        netShoes.addObserver(ecommerces);
        amazon.addObserver(ecommerces);
        System.out.println("Pedidos antes:");
        for(Ecommerce e:ecommerces.getLista()){
            for(Pedido p:e.getPedidos()){
                System.outprintln(p);
            }
        }

        netShoes.addPedidosToDatabase(new Pedido(0,"A","A","A",5,"A"), "A");

        System.out.println("Pedidos depois:");
        for(Ecommerce e:ecommerces.getLista()){
            for(Pedido p:e.getPedidos()){
                System.outprintln(p);
            }
        }

        
    }
}