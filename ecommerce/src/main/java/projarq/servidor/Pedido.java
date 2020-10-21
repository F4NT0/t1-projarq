package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;
import Produto;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private String status;
    private String data; //data do pedido
    private int prasoMaximoEntrega;//dias maximos da entrega ate quando deve ser entregue
    private int prasoEntregado;//dias que demoraram para serem entregues
    private ArrayList<Produto> listaProdutos;

    public Pedido(int idPedido, int idCliente, String status, int prasoMaximoEntrega, String data){
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.status = status;
        this.prasoMaximoEntrega = prasoMaximoEntrega;
        this.data = data;
        listaProdutos = new ArrayList<Produto>();
    }

    public int getIdPedido() {
        return idPedido;
    }
    public String getStatus() {
        return status;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public int getPrasoMaximoEntrega() {
        return prasoMaximoEntrega;
    }
    public int getPrasoEntregado() {
        return prasoEntregado;
    }
    public String getData() {
        return data;
    }
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void addProduto(Produto prod){//adiciona produtos na lista
        listaProdutos.add(prod);
    }
    public void removeProduto(Produto prod){//remove produtos na lista
        listaProdutos.remove(prod);
    }
}