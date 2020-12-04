package ecommerce2.servidor;

import java.util.ArrayList;

public class Ecommerce extends ObservableEcommerce{

    private int idEcommerce;
    private String nomeEcommerce;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ListaEcommercesObserver ecommerces = new ListaEcommercesObserver();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Database db = new Database();

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
     * Adiciona um produto em um Ecommerce específico, procurando ele no 
     * banco de dados dos Ecommerces
     * @param prod
     * @param eco
     * @return boolean
     */
    public boolean addProdutosToDatabase(Produto prod, String eco){
        for(int i = 0 ; i < this.ecommerces.getLista().size() ; i++){
            if(ecommerces.getLista().get(i).getNomeEcommerce().equals(eco)){
               this.db.addProdutosToList(prod);
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
        for(int i = 0 ; i < this.ecommerces.getLista().size() ; i++){
            if(this.ecommerces.getLista().get(i).getNomeEcommerce().equals(eco)){
                this.db.addPedidosToList(ped);
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
        return ecommerces.getLista();
    }
}