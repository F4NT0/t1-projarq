package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;

public class Ecommerce extends Thread {
    private int idEcommerce;
    private String nome;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Ecommerce> db = new ArrayList<Ecommerce>();
    private ArrayList<Produto> prods = new ArrayList<Produto>();

    // Construtor 1
    public Ecommerce(int idEcommerce, String nome){
        this.idEcommerce = idEcommerce;
        this.nome = nome;
    }

    // Construtor 2
    public Ecommerce(){}

    public int getIdEcommerce() {return idEcommerce;}

    public String getNome(){return nome;}

    public ArrayList<Produto> getProds(){return prods;}
    public ArrayList<Pedido> getPedidos(){return pedidos;}

    // Banco de Dados dos E-commerces

    public void getDatabase(){
        System.out.println("\n");
        System.out.println("\033[0;35m╭───────────────────────────────╮");
        System.out.println("\033[0;35m| Banco de Dados de E-commerces |");
        System.out.println("\033[0;35m╰───────────────────────────────╯");
        System.out.println("\n");
        for(Ecommerce valor : db){
            System.out.println("\033[0;35m❱ E-COMMERCE: " + valor.getNome() + " | ID: " + valor.getIdEcommerce() + "\033[0m");
        }
    }
    public void addToDatabase(Ecommerce eco){
        this.db.add(eco);
    }

    public void getProdutosDatabase(){
        for(int i = 0 ; i < this.db.size() ; i++){
            System.out.println("\n");
            System.out.println("\033[0;34m E-COMMERCE " + this.db.get(i).getNome());
            System.out.println("\033[0;34m╭───────────────────────────────╮");
            System.out.println("\033[0;34m| Banco de Dados dos Produtos   |");
            System.out.println("\033[0;34m╰───────────────────────────────╯");
            System.out.println("\n");
            ArrayList<Produto> aux = this.db.get(i).getProds();
            for(int j = 0 ; j < aux.size() ; j++){
                System.out.println("\033[0;34m❱ PRODUTO: " + aux.get(j).getNome() + " | ID: " + aux.get(j).getId() + " | PREÇO: " + aux.get(j).getPreco() + "\033[0m");
            }
        }
    }

    public void addToProdsDatabase(Produto prod, String eco){
        for(int i = 0 ; i < this.db.size() ; i++){
            System.out.println(this.db.get(i).getNome());
            if(this.db.get(i).getNome().equals(eco)){
                this.db.get(i).getProds().add(prod);
            }
        }
    }

    public void getPedidosDatabase(){
        for(int i = 0 ; i < this.db.size() ; i++){
            System.out.println("\n");
            System.out.println("\033[0;31m E-COMMERCE " + this.db.get(i).getNome());
            System.out.println("\033[0;31m╭──────────────────────────────╮");
            System.out.println("\033[0;31m| Banco de Dados dos Pedidos   |");
            System.out.println("\033[0;31m╰──────────────────────────────╯");
            System.out.println("\n");
            ArrayList<Pedido> aux = this.db.get(i).getPedidos();
            for(int j = 0 ; j < aux.size() ; j++){
                System.out.println("\033[0;31m❱ CLIENTE: " + aux.get(j).getNomeCliente() + " | ID: " + aux.get(j).getIdPedido() + " | ENTREGA: " + aux.get(j).getPrasoMaximoEntrega() + "\033[0m");
            }
        }
    }

    public void addToPedidosDatabase(Pedido ped, String eco){
        for(int i = 0 ; i < this.db.size() ; i++){
            System.out.println(this.db.get(i).getNome());
            if(this.db.get(i).getNome().equals(eco)){
                this.db.get(i).getPedidos().add(ped);
            }
        }
    }
}