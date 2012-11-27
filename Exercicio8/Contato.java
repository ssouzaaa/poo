package Exercicio8;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Serializable, Comparable<Contato>{

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
	@Override
	public int compareTo(Contato o) {
		if(this.nome.compareTo(o.getNome()) == 0 & this.telefone.compareTo(o.getTelefone()) == 0){
			return 0;
		}else if(this.nome.compareTo(o.getNome()) < 0 ){
			return -1;
		}else{
		return 1;
		}
	}
	public boolean equals(Object o){
		if(!(o instanceof Contato)){
			return false;
		}else{
			Contato c = (Contato) o;
			if(this.nome.equals(c.getNome())){
				return true;
			}else{
				return false;
			}
		}
	}
	public String toString(){
		return "O nome é: " + this.nome + "O telefone é: " + this.telefone;
	}
}



