package Exercicio5;

public class ContatoInexistenteException extends Exception {

	public ContatoInexistenteException(String n){
		super(n);
	}
	public ContatoInexistenteException(){
		this("Contato Inexistente");
	}
}
