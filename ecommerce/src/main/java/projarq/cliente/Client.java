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

            System.out.print("Digite [login] para se iniciar sua Sessão: ");
            String message = in.next();

            while(connection){
 
                if(message.equals("login")){
                    System.out.print("Digite seu nome na seguinte estrutura [user:seu nome]: ");
                    String name = in.nextLine();
                    writer.println(name);
                }

                //Recebe dados do Servidor
                String receive = reader.readLine();
                System.out.println(receive);

                if(receive.equals("fechar")){
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