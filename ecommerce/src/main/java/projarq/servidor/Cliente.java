package ecommerce.src.main.java.projarq.servidor;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private int cpf;
    private int idCliente;
    private ArrayList<Cliente> db = new ArrayList<Cliente>();

    // Construtor 1
    public Cliente(String nome, int cpf){
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
        for(Cliente valor : db){
            System.out.println("Cliente " + valor.getNome() + " / CPF " + valor.getCpf());
        }
    }

    public boolean checkLogin(String nome, int senha){
        for(int i = 0 ; i < db.size() ; i++){
            if(db.get(i).getNome().equals(nome)){
                if(db.get(i).getCpf() == senha){
                    return true;
                }else{return false;}
            }else{return false;}
        }
        return false;
    }
}