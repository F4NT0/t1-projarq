package ecommerce.src.main.java.projarq.servidor;

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

    public void adicionaPedido(Pedido p){
        pedidos.add(p);
    }

    public void requisicao(int idCliente,int opcao){
        if(opcao == 1){//mostrar status dos pedidos do cliente
            ArrayList<Pedido> lista = pedidosDoCliente(idCliente);
            for (Pedido ped:lista) {
                System.out.println("Id: "+ped.getIdPedido()+"    Status: "+ped.getStatus());
            }
        }else if(opcao == 2){
            gerarRelatorio(idCliente);
        }else{
            System.out.println("Opção não encontrada.");
        }
    }

    public ArrayList<Pedido> pedidosDoCliente(int idCliente){
        ArrayList<Pedido> ret = new ArrayList<Pedido>();
        for (Pedido pedido: pedidos) {
            if(pedido.getIdCliente() == idCliente){//achou o pedido daquele cliente
                ret.add(pedido);
            }
        }
        System.out.println("Ecommerce: "+this.nome);
        System.out.println("Pedidos do cliente: "+idCliente);
        for (Pedido ped:ret) {
            System.out.println("Pedido: "+ped.getIdPedido()+"  Status: "+ped.getStatus());
        }
        return ret;
    }

    public void gerarRelatorio(int idCliente){
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        for (Pedido pedido: pedidos) {
            if(pedido.getIdCliente() == idCliente){//achou o pedido daquele cliente
                lista.add(pedido);
            }
        }
        System.out.println("Ecommerce: "+this.nome+"\n");
        for(Pedido ped: lista){
            System.out.println("Data: "+ped.getData()+"  Agilidade: "+ped.getPrasoEntregado()+"  Qtd Dias Previstos:"+ped.getPrasoMaximoEntrega());
        }
    }
}