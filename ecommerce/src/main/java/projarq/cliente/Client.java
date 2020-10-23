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
        String econame = "";



        try(Socket socket = new Socket("localhost",8184)){

            // Recebendo do Servidor
            // InputStream input = socket.getInputStream();
            // BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Enviando ao Servidor
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
                    dataConcat = "data:" + nomeCliente + ":" + cpf;
                    writer.println(dataConcat);
                }
            }
        
           
            while(connection){
                //Recebe dados do Servidor
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String receive = reader.readLine();

                if(receive.equals("exit")){
                    connection = false;
                    continue;
                }
                if(receive.equals("Desculpe, chegou o limite de usuarios no momento")){
                    System.out.println(receive);
                    connection = false;
                }
                if(receive.equals("created")){
                    System.out.println("Sua conta foi criada com Sucesso!");
                    System.out.println("➤ USUÁRIO: " + nomeCliente);
                    System.out.println("➤ SENHA: " + cpf);
                    System.out.println("Anote esses dados para futuro login\n\n");
                    String selection = options();
                    System.out.println("Entrada de Retorno: " + selection);
                    writer.println(selection);
                    continue;
                    
                }
                if(receive.equals("granted")){
                    System.out.println("\nBem vindo de volta " + nomeCliente);
                    String selection = options();
                    writer.println(selection);
                    continue;
                }
                if(receive.equals("error")){
                    String data[] = receive.split(":");
                    System.out.println("Login Falhou!");
                    connection = false;
                }
                if(receive.equals("vincular")){
                    System.out.print("Digite o nome do seu Ecommerce: ");
                    econame = in.next();
                    writer.println("eco:" + econame);
                    continue;
                }
                if(receive.equals("produtos")){
                    System.out.print("Digite o nome do Produto: ");
                    String nomeProduto = in.next();
                    System.out.print("Digite uma descrição do Produto: ");
                    String descProduto = in.next();
                    System.out.print("Digite o preço do Produto: ");
                    String precProduto = in.next();
                    String concatData = "prod:" + econame + ": " + nomeProduto + ":" + descProduto + ":" + precProduto;
                    writer.println(concatData);
                    continue;
                }
                if(receive.equals("pedidos")){
                    System.out.println("Selecionado Verificar!");
                }   
                if(receive.equals("eco created")){
                    System.out.println("\nE-commerce " + econame + " criado com Sucesso!");
                    String selection = options2();
                    System.out.println("Saida: " + selection);
                    writer.println(selection);
                    continue;
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

    public static String options(){
        Scanner in = new Scanner(System.in);
        System.out.println("Como Deseja interagir no Sistema?\n");
        System.out.println("❱ Sou dono de Ecommerce e desejo [vincular] meu sistema ao gerenciador.");
        System.out.println("❱ Desejo Cadastrar [produtos].");
        System.out.println("❱ Desejo Verificar todos os [pedidos]");
        System.out.println("❱ [sair] do Sistema");
        System.out.print("\nDigite sua opção desejada: ");
        String select = in.next();
        return select;
    }
    public static String options2(){
        Scanner in = new Scanner(System.in);
        System.out.println("O que deseja fazer no E-Commerce?\n");
        System.out.println("❱ Cadastrar [produto].");
        System.out.println("❱ Verificar [pedidos].");
        System.out.print("\nDigite sua opção desejada: ");
        String select = in.next();
        return select;
    }
}