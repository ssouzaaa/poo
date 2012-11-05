package POO;

import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle {

	List<Pedido> pedidos;
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int qnt = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				qnt++;
			}
		}
		return qnt;
	}
	
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncluindoProduto(long Produto) {
		List<Pedido> p1 = new ArrayList<Pedido>();
		for(Pedido p : pedidos){
			for(ItemDePedido i : p.getItens()){
				if(i.getCodProduto() == Produto){
					p1.add(p);
				}
			}
		}
		return p1;
	}
	public void removePedido(long numPedido) {
		this.pedidos.remove(numPedido);
	}

}
