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
        String cpf = "";
        String dataConcat;



        try(Socket socket = new Socket("localhost",8184)){

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //Envia dados para o Servidor
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║ BEM VINDO AO GERÊNCIADOR DE E-COMMERCES ║");
            System.out.println("╚═════════════════════════════════════════╝");

            //Fazendo login
            System.out.print("Deseja Logar ou se Cadastrar no Sistema? [login/sign up]: ");
            message = in.nextLine();
            if(message.equals("login")){
                System.out.print("Por favor, Digite o seu nome de usuário: ");
                message = in.nextLine();
                    
                System.out.print("Por favor, Digite a sua senha: ");
                String pass = in.nextLine();

                //Enviando para o Servidor
                String userCheck = "user:" + message + ":" + pass;
                writer.println(userCheck);

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
                }
            }
        
           
            while(connection){
                //Recebe dados do Servidor
                String receive = reader.readLine();

                if(receive.equals("Desculpe, chegou o limite de usuarios no momento")){
                    System.out.println(receive);
                    connection = false;
                }
                if(receive.equals("created")){
                    System.out.println("Sua conta foi criada com Sucesso!");
                    System.out.println("Sua senha de acesso é " + cpf + " !");
                }
                if(receive.equals("granted")){
                    System.out.println("Bem vindo de volta " + nomeCliente);
                }
                if(receive.substring(0,5).equals("error")){
                    String data[] = receive.split(":");
                    System.out.println("Login Falhou!");
                    System.out.println("Cliente: " + data[1] + " / Senha: " + data[2]);
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