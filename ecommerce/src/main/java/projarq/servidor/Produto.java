package ecommerce.src.main.java.projarq.servidor;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String eco;

    public Produto(int id, String eco, String nome, String descricao,double preco){
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.eco = eco;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEco(){return eco;}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

}