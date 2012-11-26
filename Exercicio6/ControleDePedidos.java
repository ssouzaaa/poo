package Exercicio6;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class ControleDePedidos implements InterfaceSistemaDeControle{
	private List<Pedido> pedidos;
	private GravadorDePedidos gravador;

	
	public ControleDePedidos(){
		gravador = new GravadorDePedidos();
		carregaPedidos();
	}	

	public void salvarPedidos(){
		try{
			gravador.gravaPedido(pedidos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}


	}
	private void carregaPedidos(){
		try{
			pedidos = gravador.lePedido();
		}
		catch(IOException e){
			System.err.println(e.getMessage());
			System.out.println("Foi criado um novo arquivo.");
			this.pedidos = new ArrayList<Pedido>();
		}
	}

	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int qtd = 0;
		for(Pedido p: this.pedidos){
			if(p.getCliente().getNome() == nomeCliente){
				qtd++;
			}
		}
		return qtd;
	}
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncuindoProduto(long codProduto){
		List<Pedido> aux = new ArrayList<Pedido>();
		for(Pedido p: this.pedidos){
			List<ItemDePedido> itens = p.getItens();
			for(ItemDePedido item:itens){
				if(item.getCodProduto() == codProduto){
					aux.add(p);
					break;
				}
			}
		}
		return aux;
	}
	public void removePedido(long numPedido){
		for(Pedido p: this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				break;
			}
		}
	}
}

