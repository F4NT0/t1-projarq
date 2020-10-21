package source.servidores;

import java.io.*;
import java.net.*;


public class Server {
   public static void main(String[] args){
       try(ServerSocket serverSocket = new ServerSocket(8184);){
            System.out.println("Servidor rodando na Porta 8184!");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Novo Cliente Conectado");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output,true);

                //Envia dado para o Cliente
                writer.println("Seja bem vindo ao Sistema de E-commerce!");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                //Recebe dados do Cliente
                String text = reader.readLine();
                System.out.println(text);

                if(text.equals("teste")){
                    writer.println("sair");
                }
            }
       }catch(IOException e){
           System.err.println(e);
       }
   }
    
}