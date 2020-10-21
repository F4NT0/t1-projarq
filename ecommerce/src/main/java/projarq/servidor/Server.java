package ecommerce.src.main.java.projarq.servidor;

import java.io.*;
import java.net.*;


public class Server {
   public static void main(String[] args){
       try(ServerSocket serverSocket = new ServerSocket(8184);){
            System.out.println("Servidor rodando na Porta 8184!");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Iniciando Login...");

                // writer envia dados ao Cliente
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output,true);

                // reader recebe dados do cliente
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String text = reader.readLine();
                System.out.println("Recebido do Cliente: " + text);

                /**
                * OPÇÕES DE RECEBIDOS
                */

                if(text.equals("login")){
                    writer.println("[SERVIDOR] Login Recebido");
                }

                if(text.substring(0,6).equals("user:")){
                    System.out.println("Cliente " + text.substring(6,text.length()) + " Conectado!");
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