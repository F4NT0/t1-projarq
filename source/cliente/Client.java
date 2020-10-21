package source.cliente;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        boolean connection = true;
        Scanner in = new Scanner(System.in);
        try(Socket socket = new Socket("localhost",8184)){

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //Recebe dados do Servidor
            String text = reader.readLine();
            System.out.println(text);

            //Envia dados para o Servidor
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            while(connection){
               System.out.println("Digite uma mensagem: ");
               var message = in.next();
               writer.println(message);

                //Recebe dados do Servidor
                String receive = reader.readLine();
                System.out.println(receive);

            }

        }catch(UnknownHostException e){
            System.err.println("Server not Found!");
        }catch(IOException e){
            System.err.println("I/O ERROR! " + e);
        }
    }
}