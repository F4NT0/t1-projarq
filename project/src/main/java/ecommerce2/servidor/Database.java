package ecommerce2.servidor;

// Import
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;

class Database{
    //Atributos
    private ArrayList<String> ecommerces = new ArrayList<String>();
    private ArrayList<String> produtos = new ArrayList<String>();
    private ArrayList<String> pedidos = new ArrayList<String>();
    private ArrayList<String> clientes = new ArrayList<String>();

    public Database(){}

    public ArrayList<String> getListaClientes(){
        return this.clientes;
    }

    public void addEcommercesToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("database/ecommerces.txt","utf-8");
            for(String values : ecommerces){
                writer.println(values+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addProdutoToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("database/produtos.txt","utf-8");
            for(String values : produtos){
                writer.println(values+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addPedidoToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("database/pedidos.txt","utf-8");
            for(String values : pedidos){
                writer.println(values+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addClienteToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("database/clientes.txt","utf-8");
            for(String values : clientes){
                writer.println(values+"\n");
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

    public void initialize(){
        try {
            FileReader arq = new FileReader("database/clientes.txt");
            BufferedReader lerArq = new BufferedReader(arq);
      
            String linha = lerArq.readLine(); // lê a primeira linha
      // a variável "linha" recebe o valor "null" quando o processo
      // de repetição atingir o final do arquivo texto
            while (linha != null) {
              //System.out.printf("%s\n", linha);
                this.clientes.add(linha);
              linha = lerArq.readLine(); // lê a proxima linha
            }
      
            arq.close();
          } catch (IOException e) {
              System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
          }
    }

    public static void main(String[] args) throws IOException{
        Database database = new Database();
        Ecommerce eco = new Ecommerce(1,"Fantolino");
        Produto prod = new Produto(1,"Popo","PS5","descricao",123.00);
       // Cliente client = new Cliente(1,"Pedro",1234);
        Cliente client= Cliente.getInstance();
        client.setCpf(3456);
        client.setNome("Fanto");
        client.setId(1);
        Pedido ped = new Pedido(1,"Pepe","Pedro","Em Andamento",3,"24/03/2020");
        
        database.addEcommerceToList(eco);
        database.addProdutosToList(prod);
        database.addClientesToList(client);
        database.addPedidosToList(ped);

        // Exemplo de Pegando os Dados
        FileReader fileReader = new FileReader("database/clientes.txt");
        char[] data = new char[100];
        fileReader.read(data);
        String newData = "";
        for(char valor : data){newData += valor;}
        String[] slachOff = new String[3];
        slachOff = newData.split("-");
        for(String valor : slachOff){System.out.println(valor);}
    }
}