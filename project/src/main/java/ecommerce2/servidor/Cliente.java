package ecommerce2.servidor;

import java.util.ArrayList;

public class Cliente {
    private String nomeCliente;
    private int cpfCliente;
    private int idCliente;
    private ArrayList<Cliente> db = new ArrayList<Cliente>();

    public Cliente(int idCliente, String nome, int cpf){
        this.idCliente = idCliente;
        nomeCliente = nome;
        cpfCliente = cpf;
    }

    public Cliente(){

    }

    public String getNome() {
        return nomeCliente;
    }

    public int getCpf() {
        return cpfCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setNome(String nome){
        nomeCliente = nome;
    }

    public void setCpf(int cpf){
        cpfCliente = cpf;
    }

    public void setId(int id){
        idCliente = id;
    }

    public boolean clienteDatabase(Cliente cl){
        this.db.add(cl);
        return true;
    }

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