package ecommerce2.cliente;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client{
    
    public static void main(String args[]){

        //Atributos
        boolean connection = true;
        String message;
        String nomeCliente = "";
        String cpf = "";
        String dataConcat;
        String econame = "";
        try(Socket socket = new Socket("localhost",8184)){

            Scanner in = new Scanner(System.in);

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
                    System.out.println("\nSua conta foi criada com Sucesso!");
                    System.out.println("➤ USUÁRIO: " + nomeCliente);
                    System.out.println("➤ SENHA: " + cpf);
                    System.out.println("Anote esses dados para futuro login\n\n");
                    String selection = options();
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
                    String pedido1 = options3(econame);
                    String ped[] = new String[7];
                    ped = pedido1.split(":");
                    System.out.println("--------------------------------");
                    System.out.println("\nCliente: " + ped[1]);
                    System.out.println("\nEntrega: " + ped[5]);
                    System.out.println("\nID: " + ped[2]);
                    System.out.println("\nData: " + ped[6]);
                    System.out.println("--------------------------------");

                    writer.println(pedido1);
                }   
                if(receive.equals("eco created")){
                    System.out.println("\nE-commerce " + econame + " criado com Sucesso!");
                    String selection = options2();
                    writer.println(selection);
                    continue;
                }
                if(receive.equals("reset")){
                    String selection = options2();
                    writer.println(selection);
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
    /**
     * Primeira Interação do Cliente
     * @return
     */
    public static String options(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nComo deseja interagir no Sistema?\n");
        System.out.println("❱ Sou dono de Ecommerce e desejo [vincular] meu sistema ao gerenciador.");
        System.out.println("❱ Desejo Cadastrar [produtos].");
        System.out.println("❱ Desejo Verificar os [pedidos]");
        System.out.println("❱ [sair] do Sistema");
        System.out.print("\nDigite sua opção desejada: ");
        String select = in.next();
        in.close();
        return select;
    }

    /**
     * Segunda Interação do Cliente
     * @return
     */
    public static String options2(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nO que deseja fazer no E-Commerce?\n");
        System.out.println("❱ Cadastrar [produtos].");
        System.out.println("❱ Verificar [pedidos].");
        System.out.println("❱ [vincular] outro E-Commerce.");
        System.out.println("❱ [sair].");
        System.out.print("\nDigite sua opção desejada: ");
        String select = in.next();
        in.close();
        return select;
    }

    /**
     * Terceira Interação do Cliente
     * @param eco
     * @return
     */
    public static String options3(String eco){
        String pedido1 = "ped:" + eco + ":1:Fulano:Ativo:35:02/02/2020";
        return pedido1;   
    }
}