package ecommerce2.servidor;

// Import
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Database {
    //Atributos
    private ArrayList<String> ecommerces = new ArrayList<String>();
    private ArrayList<String> produtos = new ArrayList<String>();
    private ArrayList<String> pedidos = new ArrayList<String>();
    private ArrayList<String> clientes = new ArrayList<String>();

    public Database(){}

    public void addEcommercesToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("project/src/database/ecommerces.txt","utf-8");
            for(String values : ecommerces){
                writer.println(values);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addProdutoToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("project/src/database/produtos.txt","utf-8");
            for(String values : produtos){
                writer.println(values);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addPedidoToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("project/src/database/pedidos.txt","utf-8");
            for(String values : pedidos){
                writer.println(values);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addClienteToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("project/src/database/clientes.txt","utf-8");
            for(String values : clientes){
                writer.println(values);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean addEcommerceToList(Ecommerce eco){
        String data = "id:" + eco.getIdEcommerce() + "-" + "nome:" + eco.getNomeEcommerce();
        ecommerces.add(data);
        addEcommercesToDatabase();
        return true;
    }

    public boolean addProdutosToList(Produto prod){
        String data = "id:" + prod.getIdProduto() + "-" + "eco:" + prod.getEcommerceProduto() + "-" + "nome:" + prod.getNomeProduto() + "-" + "desc:" + prod.getDescricaoProduto() + "-" + "preco:" + prod.getPrecoProduto();
        produtos.add(data);
        addProdutoToDatabase();
        return true;
    }

    public boolean addPedidosToList(Pedido ped){
        String data = "id:" + ped.getIdPedido() + "-" + "eco:" + ped.getNomeEcommerce() + "-" + "cliente:" + ped.getNomeCliente() + "-" + "status:" + ped.getStatus() + "-" + "max:" + ped.getPrazoMaximoEntrega() + "-" + "data:" + ped.getData();
        pedidos.add(data);
        addPedidoToDatabase();
        return true;
    }

    public boolean addClientesToList(Cliente client){
        String data = "id:" + client.getIdCliente() + "-" + "nome:" + client.getNome() + "-" + "cpf:" + client.getCpf();
        clientes.add(data);
        addClienteToDatabase();
        return true;
    }

    public void watchEcommerceList(){
        for(String values : ecommerces){
            System.out.println("Ecommerce: " + values);
        }
    }

    public static void main(String[] args){
        Database database = new Database();
        Ecommerce eco = new Ecommerce(1,"Pepe");
        Produto prod = new Produto(1,"Pepe","PS5","descricao",123.00);
       // Cliente client = new Cliente(1,"Pedro",1234);
        Cliente client= Cliente.getInstance();
        client.setCpf(1234);
        client.setNome("Pedro");
        client.setId(1);
        Pedido ped = new Pedido(1,"Pepe","Pedro","Em Andamento",3,"24/03/2020");
        
        database.addEcommerceToList(eco);
        database.addProdutosToList(prod);
        database.addClientesToList(client);
        database.addPedidosToList(ped);

    }
}