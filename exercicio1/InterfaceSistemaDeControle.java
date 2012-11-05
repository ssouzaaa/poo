package POO;

import java.util.List;

public interface InterfaceSistemaDeControle {

	void adicionaPedido(Pedido p);
	List<Pedido> pesquisaPedidosIncluindoProduto(long Produto);
	void removePedido(long numPedido);
}
