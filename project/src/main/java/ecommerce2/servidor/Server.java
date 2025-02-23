package ecommerce2.servidor;

import java.io.*;
import java.net.*;
// import ecommerce2.cliente.Client;
// import ecommerce2.servidor.*;


public class Server {
    public static void main(String args[]){
        String clientData[] = new String[3];
        // Cliente clientesOnline[] = new Cliente[4];
        int ecoAux = 1;
        int userAux = 1;
        int prodAux = 1;
        Cliente clientesDatabase = Cliente.getInstance();
        //Ecommerce ecommerceDatabase = new Ecommerce();
        Database database = new Database();
        
        try(ServerSocket serverSocket = new ServerSocket(8184);){
            System.out.println("Servidor rodando na Porta 8184!");
            while(true){
                Socket socket = serverSocket.accept();

                // writer envia dados ao Cliente
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output,true);

                // reader recebe dados do cliente
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String text;
               
                do{
                    text = reader.readLine();

                    if(text.equals("sair")){
                        writer.println("exit");
                        continue;
                    }

                    if(text.substring(0,5).equals("data:")){
                        clientData = text.split(":");
                        int cpf = Integer.parseInt(clientData[2]);
                        Cliente addNew = Cliente.getInstance();
                        addNew.setId(userAux);
                        addNew.setNome(clientData[1]);
                        addNew.setCpf(cpf);
                        database.addClientesToList(addNew);
                        System.out.println("\nCliente " + clientData[1] + " foi Criado com Sucesso!\n");
                        writer.println("created");
                        userAux++;
                        continue;
                    }

                    if(text.equals("vincular")){
                        writer.println("vincular");
                        
                    }
    
                    if(text.equals("produtos")){
                        writer.println("produtos");
                            
                    }
    
                    if(text.equals("pedidos")){
                        writer.println("pedidos");
                            
                    }
    
                    if(text.substring(0,5).equals("user:")){
                        clientData = text.split(":");
                        int cpf = Integer.parseInt(clientData[2]);
                        boolean check = clientesDatabase.checkLogin(clientData[1], cpf);
                        if(check == true){
                            writer.println("granted");
                            System.out.println("\nCliente " + clientData[1] + " Logado com Sucesso!\n");
                        }else{
                            writer.println("error");
                        }
                            
                    }
    
                    if(text.substring(0,4).equals("ped:")){
                        String ped[] = new String[7];
                        ped = text.split(":");
                        int id = Integer.parseInt(ped[2]);
                        int tempo = Integer.parseInt(ped[5]);
                        Pedido pedido = new Pedido(id,ped[1],ped[3],ped[4],tempo,ped[6]);
                        database.addPedidosToList(pedido);
                        writer.println("reset");       
                    }
    
                    if(text.substring(0,4).equals("eco:")){
                        String eco[] = new String[2];
                        eco = text.split(":");
                        Ecommerce newEco = new Ecommerce(ecoAux,eco[1]);
                        database.addEcommerceToList(newEco);
                        database.watchEcommerceList();
                        //ecommerceDatabase.addEcommerceToDatabase(newEco);
                        writer.println("eco created");
                        //ecommerceDatabase.visualizeEcommerceDatabase();
                        ecoAux++;        
                    }
    
                    if(text.substring(0,5).equals("prod:")){
                        String prod[] = new String[5];
                        prod = text.split(":");
                        double preco = Double.parseDouble(prod[4]);
                        Produto produto = new Produto(prodAux,prod[1],prod[2],prod[3],preco);
                        database.addProdutosToList(produto);
                        //ecommerceDatabase.addProdutosToDatabase(produto,prod[1]);
                        //ecommerceDatabase.visualizeProdutosDatabase();
                        prodAux++;
                        writer.println("reset");
                    }

                }while(!text.equals("sair"));
            }
        }catch(IOException e){
           System.err.println(e);
        }catch(NullPointerException e){
            System.err.println("Entrada foi nula!");
        }
    }
}