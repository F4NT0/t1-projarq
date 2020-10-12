package source.servidores;

import java.util.ArrayList;

public class Ecommerce extends Thread {
    private int idEcommerce;
    private String nome;
    private ArrayList<Pedido> pedidos;

    public Ecommerce(int idEcommerce, String nome){
        this.idEcommerce = idEcommerce;
        this.nome = nome;
        pedidos = new ArrayList<Pedido>();
    }

    public int getIdEcommerce() {
        return idEcommerce;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public void run(){
        
    }

    public 

    public ArrayList<Pedido> pedidosDoCliente(int idCliente){
        ArrayList<Pedido> ret = new ArrayList<Pedido>();
        for (Pedido pedido: pedidos) {
            if(pedido.getIdCliente() == idCliente){//achou o pedido daquele cliente
                ret.add(pedido);
            }
        }
        return ret;
    }
}