package ecommerce2.servidor;

import java.util.ArrayList;

public class Cliente {
    private String nomeCliente;
    private static Cliente cliente;
    private int cpfCliente;
    private int idCliente;
    private ArrayList<Cliente> db = new ArrayList<Cliente>();

    private Cliente(){}

    private Cliente(int id, String nome, int cpf){
        idCliente = id;
        nomeCliente = nome;
        cpfCliente = cpf;
    }

    public static Cliente getInstance(){
        if(cliente==null){cliente=new Cliente();}
        return cliente;
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