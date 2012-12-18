package Exercicio7;

@SuppressWarnings("serial")
public class ContatoExistenteException extends Exception{
		public ContatoExistenteException(){
			this("O contato nao foi encontrado na agenda.");
		}

		public ContatoExistenteException(String string) {
			super(string);
		}
	
	}


