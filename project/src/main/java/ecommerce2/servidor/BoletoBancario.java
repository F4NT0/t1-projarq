package ecommerce2.servidor;

public class BoletoBancario extends Pagamento implements TipoPagamento{
    private String nomeBeneficiario;
    private String nomePagador;
    private int data;
    public BoletoBancario (){
        this.nomeBeneficiario = "Seu Jorge Construções";
        this.nomePagador = "Marianinha de Jesus";
        this.data = 1313;
    }

    @Override public void exibirInfo() {
        System.out.println("Nome Beneficiário: "+ this.nomeBeneficiario+" Nome Pagador: "+this.nomePagador+" Data de Validade: "+this.data);
    }
}