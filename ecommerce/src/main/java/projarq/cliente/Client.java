package ecommerce.src.main.java.projarq.cliente;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        /**
         * Atributes and Objects
         */
        boolean connection = true;
        Scanner in = new Scanner(System.in);
        Cliente cliente;



        try(Socket socket = new Socket("localhost",8184)){

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //Recebe dados do Servidor
            //String text = reader.readLine();
            //System.out.println(text);

            //Envia dados para o Servidor
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            System.out.println("╔");
            System.out.println("║ BEM VINDO AO GERÊNCIADOR DE E-COMMERCES");
            System.out.println("╚");

            while(connection){
               System.out.println("Digite uma mensagem: ");
               var message = in.next();
               writer.println(message);

                //Recebe dados do Servidor
                String receive = reader.readLine();
                System.out.println(receive);

                if(receive.equals("sair")){
                    connection = false;
                }else{
                    connection = true;
                }

            }
            in.close();
            System.out.println("Muito Obrigado e volte sempre!");

        }catch(UnknownHostException e){
            System.err.println("Server not Found!");
        }catch(IOException e){
            System.err.println("I/O ERROR! " + e);
        }
    }
}