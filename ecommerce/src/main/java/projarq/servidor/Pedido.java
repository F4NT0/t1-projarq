package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private String nomeCliente;
    private String status;
    private String eco;
    private String data;
    private int prasoMaximoEntrega;
    private int prasoEntregado;
    private ArrayList<Produto> listaProdutos;

    public Pedido(int idPedido, String eco, String nomeCliente, String status, int prasoMaximoEntrega, String data){
        this.idPedido = idPedido;
        this.eco = eco;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.prasoMaximoEntrega = prasoMaximoEntrega;
        this.data = data;
        listaProdutos = new ArrayList<Produto>();
    }

    public Pedido(){}

    public int getIdPedido() {
        return idPedido;
    }
    public String getStatus() {
        return status;
    }
    public String getNomeCliente() {
        return nomeCliente;
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