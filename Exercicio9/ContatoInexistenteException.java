package Exercicio7;

@SuppressWarnings("serial")
public class ContatoInexistenteException extends Exception{
	public ContatoInexistenteException(){
		this("O contato nao foi encontrado na agenda.");
	}
	public ContatoInexistenteException(String m){
		super(m);
	}
}
