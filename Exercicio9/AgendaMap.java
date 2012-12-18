package Exercicio7;

import java.util.*;
import java.io.*;

public class AgendaMap implements AgendaIF{

	private Map<String, Contato> contatos;
	private GravadorDeContatosMap gravador;

	public AgendaMap(){
		gravador = new GravadorDeContatosMap();
		carregaContatos();
	}

	void gravaContatos(){
		try{
			gravador.gravaContatos(contatos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}


	}
	private void carregaContatos(){
		try{
			contatos = gravador.leContato();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			this.contatos = new HashMap<String, Contato>();
		}
	}

	public void adicionarContato(String nome, String tel){
		this.contatos.put(nome, new Contato(nome,tel) );
		System.out.println("Contato "  + nome + " adicionado.");
		gravaContatos();
	}

	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		if( !(this.contatos.containsKey(nomeContato)) ){
			throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
		}
		this.contatos.remove(nomeContato);
		System.out.println("Contato "  + nomeContato + " removido.");
		gravaContatos();
	}

	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException{
		if( !(this.contatos.containsKey(nomeContato)) ){
			throw new ContatoInexistenteException("Contato " + nomeContato +" nao cadastrado.");
		}
		return this.contatos.get(nomeContato);
	}

	public Collection<Contato> getContatos() {
		
		return contatos.values();
	}

	@Override
	public Iterator<Contato> getContatosOrdenados() {
		List<Contato> c = new LinkedList<Contato>();
		c.addAll(contatos.values());
		Collections.sort(c);
		return c.iterator();
		
	}

	public void adicionarContatoMap(Contato contato) throws ContatoExistenteException{
	boolean achou = false;
	for(Contato c : this.contatos.values()){
		if(c.getNome().equals(contato.getNome())){
			achou = true;
			throw new ContatoExistenteException("Contato já existente");
		}
	}
	if(achou){
		this.contatos.put(contato.getNome(),contato);
	}
}

	
}



