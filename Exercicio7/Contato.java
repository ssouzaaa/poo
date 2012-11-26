package Exercicio7;

import java.io.Serializable;

public class Contato implements Serializable{

	private String nome;
	private String telefone;

	public Contato(){
		this("fulano","00000000");
	}
	public Contato(String nome, String tel){
		this.nome = nome;
		this.telefone = tel;
	}
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setTelefone(String tel){
		this.telefone = tel;
	}
	public String getTelefone(){
		return this.telefone;
	}
}


