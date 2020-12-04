package ecommerce2.servidor;

import java.util.ArrayList;

public class Cliente {
    private String nomeCliente;
    private static Cliente cliente;
    private int cpfCliente;
    private int idCliente;
    private ArrayList<Cliente> db = new ArrayList<Cliente>();
    private Database bancodedados = new Database();

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
        bancodedados.initialize();
        for(String s:bancodedados.getListaClientes()){
            String[] parte = s.split("-");
            String nomes = parte[1].substring(5);
            String senhas = parte[2].substring(4);
            if((nomes.equals(nome))&&(senhas.equals(senha))){
                return true;
            }
        }
        return false;
    }

}