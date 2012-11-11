package Exercicio3;

public class ItemDePedido{

	private int quantidade;
	private String codProduto;
	private double valorUnitario;
	
	public ItemDePedido(int quant,String cod, double valor){
		this.quantidade = quant;
		this.codProduto = cod;
		this.valorUnitario = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
}
