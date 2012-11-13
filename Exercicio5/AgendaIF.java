package Exercicio5;

public interface AgendaIF {

	void adicionaContato(String nome,String tel);
	void removeContato(String nome) throws ContatoInexistenteException;
	Contato pesquisaContato(String nome) throws ContatoInexistenteException;
		
}
