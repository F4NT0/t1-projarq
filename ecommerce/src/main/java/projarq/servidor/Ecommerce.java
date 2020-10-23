package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;

public class Ecommerce extends Thread {
    private int idEcommerce;
    private String nome;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Ecommerce> db = new ArrayList<Ecommerce>();
    private ArrayList<Produto> prods = new ArrayList<Produto>();

    // Construtor 1
    public Ecommerce(int idEcommerce, String nome){
        this.idEcommerce = idEcommerce;
        this.nome = nome;
        pedidos = new ArrayList<Pedido>();
    }

    // Construtor 2
    public Ecommerce(){}

    public int getIdEcommerce() {return idEcommerce;}

    public String getNome(){return nome;}

    public void adicionaPedido(Pedido p){pedidos.add(p);}

    public ArrayList<Produto> getProds(){return prods;}

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
}