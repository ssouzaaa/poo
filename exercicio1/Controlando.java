package POO;

public class Controlando {

	
	public static void main(String[] args) {
		
		Pedido p1 = new Pedido(8);
		Pedido p2 = new Pedido(4);
		
		Cliente cli = new Cliente("Italo");
		ControleDePedidos control = new ControleDePedidos();
	
		p1.setCliente(cli);
		p2.setCliente(cli);
		
		control.adicionaPedido(p1);
		control.adicionaPedido(p2);
		
		if(control.calculaQuantidadeDePedidosDoCliente("Italo") == 2){
			System.out.println("Programa Correto");
		}else{
			System.out.println("Programa Incorreto");
		}
			
		
	}

}
