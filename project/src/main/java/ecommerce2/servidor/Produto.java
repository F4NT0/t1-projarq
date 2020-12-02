package ecommerce2.servidor;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double precoProduto;
    private String ecommerce;

    /**
     * Método construtor da Classe Produto
     * @param id
     * @param eco
     * @param nome
     * @param descricao
     * @param preco
     */
    public Produto(int id, String eco, String nome, String descricao,double preco){
        idProduto = id;
        descricaoProduto = descricao;
        nomeProduto = nome;
        precoProduto = preco;
        ecommerce = eco;
    }

    /**
     * Método Construtor vazio (sobrecarga)
     */
    public Produto(){

    }

    /**
     * Getter do ID do produto
     * @return idProduto
     */
    public int getIdProduto(){

        System.out.println(idProduto);
        return idProduto;
    }

    /**
     * Setter do ID do produto
     * @param id
     */
    public void setId(int id){
        idProduto = id;
    }

    /**
     * Getter da Descrição do Produto
     * @return
     */
    public String getDescricaoProduto(){
        return descricaoProduto;
    }

    /**
     * Setter da Descrição do Produto
     * @param descricao
     */
    public void setDescricao(String descricao){
        descricaoProduto = descricao;
    }

    /**
     * Getter do nome do Ecommerce do Produto
     * @return
     */
    public String getEcommerceProduto(){
        return ecommerce;
    }

    /**
     * Setter do nome do Ecommerce do Produto
     * @param eco
     */
    public void setEcommerce(String eco){
        ecommerce = eco;
    }

    /**
     * Getter do nome do Produto
     * @return
     */
    public String getNomeProduto(){
        return nomeProduto;
    }

    /**
     * Setter do nome do Produto
     * @param nome
     */
    public void setNomeProduto(String nome){    
        nomeProduto = nome;
    }

    /**
     * Getter do Preço do Produto
     * @return
     */
    public double getPrecoProduto(){
        return precoProduto;
    }

    /**
     * Setter do Preço do Produto
     * @param preco
     */
    public void setPrecoProduto(double preco){
        precoProduto = preco;
    }
}