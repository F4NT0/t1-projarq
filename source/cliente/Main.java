package source.cliente;
import source.servidores.Ecommerce;
import source.servidores.Pedido;
import source.servidores.Produto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Cliente cliente1=new Cliente("Lucas",7483,1);
        Cliente cliente2=new Cliente("BolinhadeNeve",4549,2);
        Cliente cliente3=new Cliente("Dolinho",18374,3);

        Ecommerce ecommerce1=new Ecommerce(1,"Jorginho Jogos");
        Ecommerce ecommerce2=new Ecommerce(2,"Bobbi construcoes");

        Produto produto1= new Produto(1,"Genshin Impact", "Jogo gratis de mundo aberto", 0);
        Produto produto2= new Produto(1,"Farcry 5", "jogo de fps com mundo aberto", 50);
        Produto produto3= new Produto(1,"bloco de costrucao", "blocos para construcoes", 10);
        Produto produto4= new Produto(1,"Tinta de parede azul", "tinta para colorir parede de azul", 3);



        System.out.println("Bem-vindo ao centro dos Ecommerces!");
        System.out.println("Insira 1 para cadastrar um Ecommerce ou 2 para cadastrar um pedido");
        Scanner teclado= new Scanner(System.in);
        int opcao=teclado.nextInt();
        if(opcao==1){
            System.out.println("Insira o id: ");
            int id=teclado.nextInt();
            System.out.println("Insira o nome: ");
            String nome=teclado.next();

            cadastraEcommerce(id, nome);
        }
        else if(opcao==2)
        {
            System.out.println("Insira o id do pedido: ");
            int id=teclado.nextInt();
            System.out.println("Insira o id do cliente: ");
            int idC=teclado.nextInt();
            System.out.println("Insira os status do pedido: ");
            String status=teclado.next();
            System.out.println("Insira o praso maximo de entrega: ");
            int prasoMax=teclado.nextInt();
            System.out.println("Insira a data do dia da requisicao do pedido: ");
            String data=teclado.next();

            Pedido pedido=cadastraPedido(id,idC,status,prasoMax,data);

            pedido.addProduto(produto1);
            pedido.addProduto(produto2);
        }
    }

    public static Ecommerce cadastraEcommerce(int idEcommerce, String nome)
    {
        Ecommerce ecommerce=new Ecommerce(idEcommerce,nome);
        return ecommerce;
    }

    public static Pedido cadastraPedido(int idPedido, int idCliente, String status, int prasoMaximoEntrega, String data)
    {
       Pedido pedido=new Pedido(idPedido, idCliente, status, prasoMaximoEntrega,data);
        return pedido;
    }


}
