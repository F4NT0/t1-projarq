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
        boolean sendLogin = true;
        Scanner in = new Scanner(System.in);
        String message;
        String nomeCliente = "";
        String cpf;
        String dataConcat;



        try(Socket socket = new Socket("localhost",8184)){

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //Envia dados para o Servidor
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            System.out.println("╔");
            System.out.println("║ BEM VINDO AO GERÊNCIADOR DE E-COMMERCES");
            System.out.println("╚");

            //Fazendo login
           while(sendLogin){
                System.out.print("Deseja Logar ou se Cadastrar no Sistema? [login/sign up]: ");
                message = in.nextLine();
                if(message.equals("login")){
                    System.out.print("Por favor, Digite o seu nome de usuário: ");
                    message = in.nextLine();
                    if(message != nomeCliente){
                        System.out.println("Desculpe, esse usuário não existe, tente novamente!");
                    }
                    if(message.equals(nomeCliente)){
                        System.out.println("Seja bem vindo novamente " + nomeCliente + "!");
                        sendLogin = false;
                    }
                }else{
                    if(message.equals("sign up")){
                        System.out.print("Digite o seu nome para cadastro: ");
                        nomeCliente = in.nextLine();
                        System.out.print("Digite o seu CPF para cadastro: ");
                        cpf = in.next();
                        System.out.println("Seus Dados: \n");
                        System.out.println("Nome: " + nomeCliente);
                        System.out.println("CPF: " + cpf);
                        dataConcat = "data:" + nomeCliente + ":" + cpf;
                        writer.println(dataConcat);
                        sendLogin = false;
                    }else{
                        System.out.println("Desculpe, comando não reconhecido, tente novamente! ");
                    }
                }
           }
           
            while(connection){
                //Recebe dados do Servidor
                String receive = reader.readLine();

                if(receive.equals("Desculpe, chegou o limite de usuarios no momento")){
                    System.out.println(receive);
                    connection = false;
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