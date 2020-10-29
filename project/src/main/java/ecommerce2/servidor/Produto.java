package ecommerce2.servidor;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double precoProduto;
    private String ecommerce;

    public Produto(int id, String eco, String nome, String descricao,double preco){
        idProduto = id;
        descricaoProduto = descricao;
        nomeProduto = nome;
        precoProduto = preco;
        ecommerce = eco;
    }

    public Produto(){

    }

    public int getIdProduto(){
        return idProduto;
    }

    public void setId(int id){
        idProduto = id;
    }

    public String getDescricaoProduto(){
        return descricaoProduto;
    }

    public void setDescricao(String descricao){
        descricaoProduto = descricao;
    }

    public String getEcommerceProduto(){
        return ecommerce;
    }

    public void setEcommerce(String eco){
        ecommerce = eco;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nome){    
        nomeProduto = nome;
    }

    public double getPrecoProduto(){
        return precoProduto;
    }

    public void setPrecoProduto(double preco){
        precoProduto = preco;
    }
}