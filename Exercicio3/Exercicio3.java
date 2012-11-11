package Exercicio3;

import java.util.Scanner;



public class Exercicio3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Pedido pedido = new Pedido(0);
		String cod = new String();
		
		do{
			System.out.println("Qual o codigo do produto pedido? ");
			cod = s.next();
			if(Integer.parseInt(cod)!= 0){
				
				System.out.println("Quantidade desse item: ");
				int quantidade =  s.nextInt();
				System.out.println("Qual o valor unitario do produto? ");
				double valor = s.nextDouble();
				
				ItemDePedido itempedido = new ItemDePedido(quantidade, cod, valor);
				pedido.adicionaItem(itempedido);
			}
		}while(Integer.parseInt(cod)!=0);
		double valorTotal = 0;
		for(ItemDePedido p : pedido.getItens()){
			
			valorTotal += (p.getValorUnitario()*p.getQuantidade());
		}
		System.out.println("O valor total é: " + valorTotal);	
		
		
	}

}
