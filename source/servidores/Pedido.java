package source.servidores;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private ArrayList<Produto> listaProdutos;

    public Pedido(int idPedido, int idCliente){
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        listaProdutos = new ArrayList<Produto>();
    }

    public int getIdPedido() {
        return idPedido;
    }
    public int getIdCliente() {
        return idCliente;
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