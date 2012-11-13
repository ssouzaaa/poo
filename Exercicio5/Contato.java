package Exercicio5;

public class Contato {

	private String nome, tel;
	
	public Contato(){
		this("","");
	}
	public Contato(String nome, String tel){
		this.nome = nome;
		this.tel = tel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
