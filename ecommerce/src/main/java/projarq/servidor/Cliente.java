package ecommerce.src.main.java.projarq.servidor;

public class Cliente {

    private String nome;
    private int cpf;
    private int idCliente;

    public Cliente(String nome, int cpf, int idCliente)
    {
        this.nome=nome;
        this.cpf=cpf;
        this.idCliente=idCliente;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }
}