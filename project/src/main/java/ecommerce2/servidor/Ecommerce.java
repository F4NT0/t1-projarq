package ecommerce2.servidor;

import java.util.ArrayList;

public class Ecommerce extends ObservableEcommerce{
    private int idEcommerce;
    private String nomeEcommerce;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Ecommerce> ecommerces = new ArrayList<Ecommerce>();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    /**
     * Método Construtor do Ecommerce
     //* @param idEcommerce
     * @param nome
     */
    public Ecommerce(int id, String nome){
        super();
        idEcommerce = id;
        nomeEcommerce = nome;
    }

    /**
     * Sobrecarga do Método Construtor
     */
    public Ecommerce(){

    }

    /**
     * Getter do id do Ecommerce
     * @return idEcommerce
     */
    public int getIdEcommerce() {
        return idEcommerce;
    }

    /**
     * Getter do nome do Ecommerce
     * @return nome
     */
    public String getNomeEcommerce(){
        return nomeEcommerce;
    }

    /**
     * Setter do id do Ecommerce
     * @param id
     */
    public void setIdEcommerce(int id){
        idEcommerce = id;
    }

    /**
     * Setter do nome do Ecommerce
     * @param nome
     */
    public void setNomeEcommerce(String nome){
        nomeEcommerce = nome;
    }

    /**
     * Adiciona um Ecommerce no Banco de Dados de Ecommerces
     * @param eco
     * @return boolean
     */
    public boolean addEcommerceToDatabase(Ecommerce eco){
        this.ecommerces.add(eco);
        return true;
    }

    /**
     * Adiciona um produto em um Ecommerce específico, procurando ele no 
     * banco de dados dos Ecommerces
     * @param prod
     * @param eco
     * @return boolean
     */
    public boolean addProdutosToDatabase(Produto prod, String eco){
        for(int i = 0 ; i < this.ecommerces.size() ; i++){
            if(ecommerces.get(i).getNomeEcommerce().equals(eco)){
                ecommerces.get(i).getProdutos().add(prod);
            }
        }
        return true;
    }

    /**
     * Adiciona um Pedido em um Ecommerce específco
     * @param ped
     * @param eco
     * @return
     */
    public boolean addPedidosToDatabase(Pedido ped, String eco){
        for(int i = 0 ; i < this.ecommerces.size() ; i++){
            if(this.ecommerces.get(i).getNomeEcommerce().equals(eco)){
                this.ecommerces.get(i).getPedidos().add(ped);
            }
        }
        this.notifyObservers(this,ped);
        return true;
    }

    /**
     * Getter da lista de produtos do Ecommerce
     * @return
     */
    public ArrayList<Produto> getProdutos(){
        return produtos;
    }

    /**
     * Getter da lista de pedidos do Ecommerce
     * @return
     */
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    /**
     * Getter da lista de Ecommerces
     * @return
     */
    public ArrayList<Ecommerce> getEcommerces(){
        return ecommerces;
    }

    /**
     * Visualização do Banco de Dados Fictício do Ecommerce
     */
    public void visualizeEcommerceDatabase(){
        System.out.println("\n");
        System.out.println("╭───────────────────────────────╮");
        System.out.println("| Banco de Dados de E-commerces |");
        System.out.println("╰───────────────────────────────╯");
        System.out.println("\n");
        for(Ecommerce valor : this.ecommerces){
            System.out.println("E-COMMERCE: " + valor.getNomeEcommerce() + " | ID: " + valor.getIdEcommerce() + "\033[0m\n\n");
        }
    }

    /**
     * Visualização do Banco de Dados Fictício do Produto
     */
    public void visualizeProdutosDatabase(){
        for(int i = 0 ; i < this.ecommerces.size() ; i++){
            System.out.println("\n");
            System.out.println("E-COMMERCE " + this.ecommerces.get(i).getNomeEcommerce());
            System.out.println("╭───────────────────────────────╮");
            System.out.println("| Banco de Dados dos Produtos   |");
            System.out.println("╰───────────────────────────────╯");
            System.out.println("\n");
            ArrayList<Produto> aux = this.ecommerces.get(i).getProdutos();
            for(int j = 0 ; j < aux.size() ; j++){
                System.out.println("PRODUTO: " + aux.get(j).getNomeProduto() + " | ID: " + aux.get(j).getIdProduto() + " | PREÇO: " + aux.get(j).getPrecoProduto() + "\033[0m\n\n");
            }
        }
    }

    /**
     * Visualização do Banco de Dados Fictício do Pedido
     */
    public void visualizePedidosDatabase(){
        for(int i = 0 ; i < this.ecommerces.size() ; i++){
            System.out.println("\n");
            System.out.println("E-COMMERCE " + this.ecommerces.get(i).getNomeEcommerce());
            System.out.println("╭──────────────────────────────╮");
            System.out.println("| Banco de Dados dos Pedidos   |");
            System.out.println("╰──────────────────────────────╯");
            System.out.println("\n");
            ArrayList<Pedido> aux = this.ecommerces.get(i).getPedidos();
            for(int j = 0 ; j < aux.size() ; j++){
                System.out.println("CLIENTE: " + aux.get(j).getNomeCliente() + " | ID: " + aux.get(j).getIdPedido() + " | ENTREGA: " + aux.get(j).getPrazoMaximoEntrega() + "\033[0m\n\n");
            }
        }
    }


}