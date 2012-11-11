package Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Pedido{

	private long numeroDoPedido;
	private Cliente cliente;
	private List<ItemDePedido> itens;
	
	public Pedido(){
		this(0);
	}
	public Pedido(long numeroDoPedido){
		this.numeroDoPedido = numeroDoPedido;
		this.itens = new ArrayList<ItemDePedido>();
		this.cliente = new Cliente();
	}
	List<ItemDePedido> getItens(){
		return this.itens;
	}
	public long getNumeroDoPedido(){
		return numeroDoPedido;
	}
	void setNumeroDoPedido(long numeroDoPedido){
		this.numeroDoPedido = numeroDoPedido;
	}
	public Cliente getCliente(){
		return cliente;
	}
	void setCliente(Cliente c){
		this.cliente = c;
	}
	public void adicionaItem(ItemDePedido i) {
		this.itens.add(i);

	}
}