package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private int cpf;
    private int idCliente;
    private ArrayList<Cliente> db = new ArrayList<Cliente>();

    // Construtor 1
    public Cliente(int idCliente, String nome, int cpf){
        this.idCliente = idCliente;
        this.nome=nome;
        this.cpf=cpf;
    }
    // Construtor 2
    public Cliente(){}

    public String getNome() {return nome;}

    public int getCpf() {return cpf;}

    public int getIdCliente() {return idCliente;}

    public void clienteDatabase(Cliente cl){this.db.add(cl);}

    public void getDatabase(){
        System.out.println("\n");
        System.out.println("\033[0;33m╭────────────────────────────╮");
        System.out.println("\033[0;33m| Banco de Dados de Clientes |");
        System.out.println("\033[0;33m╰────────────────────────────╯");
        System.out.println("\n");
        for(Cliente valor : db){
            System.out.println("\033[0;33m❱ ID: " + valor.getIdCliente() + " | CLIENTE: " + valor.getNome() + " | SENHA: " + valor.getCpf() + "\033[0m");
        }
    }

    public boolean checkLogin(String nome, int senha){
        for(int i = 0 ; i < db.size() ; i++){
            if(db.get(i).getNome().equals(nome)){
                if(db.get(i).getCpf() == senha){
                    return true;
                }
            }
        }
        return false;
    }
}