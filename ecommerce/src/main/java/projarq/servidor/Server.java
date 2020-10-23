package ecommerce.src.main.java.projarq.servidor;

import java.io.*;
import java.net.*;

import ecommerce.src.main.java.projarq.servidor.*;

public class Server {
   public static void main(String[] args){
        //Variaveis
        String clientData[] = new String[3];
        Cliente clientesOnline[] = new Cliente[4];
        int ecoAux = 1;
        int userAux = 1;
        int prodAux = 1;

        //Banco de Dados
        Cliente clientesDatabase = new Cliente();
        Ecommerce ecommerceDatabase = new Ecommerce();

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

                /*********************
                * LIDANDO COM RECEIVE
                **********************/

                String text;
                do{
                    text = reader.readLine();

                    if(text.equals("sair")){
                        writer.println("exit");
                        continue;
                    }

                    if(text.equals("vincular")){
                        writer.println("vincular");
                        continue;
                    }
                    // Criar Produtos
                    if(text.equals("produtos")){
                        writer.println("produtos");
                        continue;
                    }
                    // Verificar Pedidos
                    if(text.equals("pedidos")){
                        System.out.println("Escolhido Pedidos");
                        writer.println("pedidos");
                        continue;
                    }

                    // Sign Up
                    if(text.substring(0,4).equals("data")){
                        clientData = text.split(":");
                        int cpf = Integer.parseInt(clientData[2]);
                        Cliente addNew = new Cliente(userAux,clientData[1],cpf);
                        clientesDatabase.clienteDatabase(addNew);
                        System.out.println("\nCliente " + clientData[1] + " foi Criado com Sucesso!\n");
                        writer.println("created");
                        userAux++;
                        clientesDatabase.getDatabase();
                        continue;
                    }

                    // Login
                    if(text.substring(0,4).equals("user")){
                        clientData = text.split(":");
                        int cpf = Integer.parseInt(clientData[2]);
                        boolean check = clientesDatabase.checkLogin(clientData[1], cpf);
                        if(check == true){
                            writer.println("granted");
                            System.out.println("\nCliente " + clientData[1] + " Logado com Sucesso!\n");
                        }else{
                            writer.println("error");
                        }
                        continue;
                    }

                    //Pedidos Cadastrados
                    if(text.substring(0,3).equals("ped")){
                        String ped[] = new String[7];
                        int id = Integer.parseInt(ped[2]);
                        int tempo = Integer.parseInt(ped[5]);
                        Pedido pedido = new Pedido(id,ped[1],ped[3],ped[4],tempo,ped[6]);
                        ecommerceDatabase.addToPedidosDatabase(pedido,ped[1]);
                        writer.println("reset");
                        continue;
                    }

                    // Criar e-commerce
                    if(text.substring(0,3).equals("eco")){
                        String eco[] = new String[2];
                        eco = text.split(":");
                        Ecommerce newEco = new Ecommerce(ecoAux,eco[1]);
                        ecommerceDatabase.addToDatabase(newEco);
                        writer.println("eco created");
                        ecommerceDatabase.getDatabase();
                        ecoAux++;
                        continue;
                    }

                    // Criar Produto
                    if(text.substring(0,4).equals("prod")){
                        System.out.println("Entrou aqui");
                        String prod[] = new String[5];
                        prod = text.split(":");
                        double preco = Double.parseDouble(prod[4]);
                        Produto produto = new Produto(prodAux,prod[1],prod[2],prod[3],preco);
                        ecommerceDatabase.addToProdsDatabase(produto,prod[1]);
                        ecommerceDatabase.getProdutosDatabase();
                        prodAux++;
                        writer.println("reset");
                        continue;
                    }

                }while(!text.equals("sair"));
            }
       }catch(IOException e){
           System.err.println(e);
       }
   }
    
}