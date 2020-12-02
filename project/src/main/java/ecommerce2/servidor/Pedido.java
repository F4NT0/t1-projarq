package ecommerce2.servidor;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private int idPedido;
    private String nomeCliente;
    private String status;
    private String eco;
    private String data;
    private int prazoMaximoEntrega;
    private static Pedido pedido;
    private ArrayList<Produto> listaProdutos;

    /**
     * Método construtor do Objeto Pedido
     * @param idPedido
     * @param eco
     * @param nomeCliente
     * @param status
     * @param prazoMaximoEntrega
     * @param data
     */
    public Pedido(int idPedido, String eco, String nomeCliente, String status, int prazoMaximoEntrega, String data){
        this.idPedido = idPedido;
        this.eco = eco;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.prazoMaximoEntrega = prazoMaximoEntrega;
        this.data = data;
        listaProdutos = new ArrayList<Produto>();
    }

    public Pedido(){
        
    }
    
    /**
     * Retorna o id do pedido
     * @return idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Retorna o nome do Ecommerce
     * @return eco
     */
    public String getNomeEcommerce(){
        return eco;
    }

    /**
     * Retorna o nome do Cliente do pedido
     * @return nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Retorna o Status do Pedido
     * EM ANDAMENTO,ENTREGUE
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Retorna o Prazo maximo de Entrega
     * @return prazoMaximoEntrega
     */
    public int getPrazoMaximoEntrega() {
        return prazoMaximoEntrega;
    }

    /**
     * Retorna a data do pedido
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * Adiciona um produto na lista de produtos
     * @param prod
     */
    public boolean addProduto(Produto prod){
        listaProdutos.add(prod);
        return true;
    }

    /**
     * Retorna a pista de produtos do pedido
     * @return listaProdutos
     */
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    /**
     * Remove o produto da lista de produtos
     * @param prod
     */
    public boolean removeProduto(Produto prod){
        listaProdutos.remove(prod);
        return true;
    }

    @Override
    public String toString(){
        return idPedido+" ";
    }
  
    public void metodoPagamento(){
        Pagamento pag = new Pagamento();
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1-Cartao , 2-Boleto , 3-PayPal");
        aux=teclado.nextInt();
        teclado.close();
        pag.criaPagamento(aux);
    }
}