package ecommerce.src.main.java.projarq.servidor;

import java.io.*;
import java.net.*;

import ecommerce.src.main.java.projarq.servidor.*;

public class Server {
   public static void main(String[] args){
        //Variaveis
        String clientData[] = new String[3];
        Cliente clientesDatabase = new Cliente();
        Cliente clientesOnline[] = new Cliente[4];

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
                    System.out.println(text);

                    // Sign Up
                    if(text.substring(0,4).equals("data")){
                        clientData = text.split(":");
                        int cpf = Integer.parseInt(clientData[2]);
                        Cliente addNew = new Cliente(clientData[1],cpf);
                        clientesDatabase.clienteDatabase(addNew);
                        System.out.println("\nCliente " + clientData[1] + " foi Criado com Sucesso!\n");
                        writer.println("created");
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
                            System.out.println("Cliente " + clientData[1] + " Logado com Sucesso!");
                        }else{
                            writer.println("error:"+clientData[1]+":"+clientData[2]);
                        }
                        continue;
                    }

                    // Criar e-commerce
                    if(text.equals("vincular")){
                        System.out.println("Escolhido Vincular");
                        writer.println("vincular");
                        continue;
                    }
                    // Fazer Compras
                    if(text.equals("comprar")){
                        System.out.println("Escolhido Comprar");
                        writer.println("comprar");
                        continue;
                    }
                    // Verificar Pedidos
                    if(text.equals("verificar")){
                        System.out.println("Escolhido Verificar");
                        writer.println("verificar");
                        continue;
                    }

                }while(!text.equals("sair"));
            }
       }catch(IOException e){
           System.err.println(e);
       }
   }
    
}