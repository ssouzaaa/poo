package Exercicio5;

public class ProgramaExercicio5 {

	
	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		agenda.adicionaContato("Italo", "99999");
		
		try {
			agenda.pesquisaContato("Italo");
		} catch (ContatoInexistenteException e) {
			System.err.println("O contato deveria existir");
		}
		try {
			agenda.pesquisaContato("Juca");
		} catch (ContatoInexistenteException e) {
			System.err.println("Não existe este contato");
		}
		try {
			agenda.removeContato("Italo");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		try {
			agenda.removeContato("Juca");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
	}

}
