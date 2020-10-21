package ecommerce.src.main.java.projarq.servidor;

import java.io.*;
import java.net.*;

import ecommerce.src.main.java.projarq.servidor.*;

public class Server {
   public static void main(String[] args){
        //Variaveis
        String clientData[] = new String[3];
        Cliente cliente;
        Cliente clientesOnline[] = new Cliente[4];
        int accessControler = 0;

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

                String text = reader.readLine();
                //System.out.println("Recebido do Cliente: " + text);

                /**
                * OPÇÕES DE RECEBIDOS
                */


                if(text.substring(0,4).equals("data")){
                    if(accessControler == 3){
                        writer.println("Desculpe, chegou o limite de usuarios no momento");
                    }else{
                        clientData = text.split(":");
                        System.out.println("\nCliente " + clientData[1] + " está Online!\n");
                        int cpf = Integer.parseInt(clientData[2]);
                        clientesOnline[accessControler] = new Cliente(clientData[1],cpf,accessControler);
                        //Verificação dos dados
                        System.out.println("Nome do Cliente: " + clientesOnline[accessControler].getNome());
                        System.out.println("CPF do Cliente: " + clientesOnline[accessControler].getCpf());
                        System.out.println("ID do Cliente: " + clientesOnline[accessControler].getIdCliente());
                        accessControler++;
                    }
                }   

                if(text.equals("sair")){
                    writer.println("fechar");
                }
            }
       }catch(IOException e){
           System.err.println(e);
       }
   }
    
}