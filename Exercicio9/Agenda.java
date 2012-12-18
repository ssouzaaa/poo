package Exercicio7;

import java.util.*;
import java.io.*;


public class Agenda implements AgendaIF{

	private List<Contato> contatos;
	private GravadorDeContatosList gravador;

	public Agenda(){
		gravador = new GravadorDeContatosList();
		carregaContatos();
	}

	private void gravaContatos(){
		try{
			gravador.gravaContato(contatos);
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
			this.contatos = new ArrayList<Contato>();
		}
	}

	public void adicionarContato(String nome, String tel){
		for(Contato c: this.contatos){
			if(c.getNome().equals(nome)){
				c.setTelefone(tel);
				gravaContatos();
				return;
			}
		}
		this.contatos.add( new Contato(nome,tel) );
		gravaContatos();
		System.out.println("Contato "  + nome + " adicionado.");
	}
	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				this.contatos.remove(c);
				gravaContatos();
				return;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
	}
	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				return c;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato +" nao cadastrado.");
	}

	@Override
	public Collection<Contato> getContatos() {
		Collection<Contato> c = new ArrayList<Contato>();
		c.addAll(this.contatos);
		return c;
	}

	@Override
	public Iterator<Contato> getContatosOrdenados() {
		Collections.sort(this.contatos);
		return this.contatos.iterator();
	}
}


