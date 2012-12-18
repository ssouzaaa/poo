package Exercicio7;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaMap {

	private AgendaMap agenda;

	@Before
	public void setUp(){
		this.agenda = new AgendaMap();
	}
	@After
	public void tearDown(){
		File file = new File("contatoMap.txt");
		if(file.exists()){
			file.delete();
		}
	}
	@Test
	public void adicionarContatoTest(){
		this.agenda.adicionarContato("gilson","91512643");
		this.agenda.adicionarContato("gilson","81818181");
		try {
			Contato c = this.agenda.pesquisarContato("gilson");
			assertTrue("81818181".equals(c.getTelefone()));
		} catch (ContatoInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}		
	}
	@Test
	public void removerTest(){
		this.agenda.adicionarContato("gilson","333");
		try{
			this.agenda.removerContato("gilson");
			//OK
		}catch(ContatoInexistenteException e){
			fail("n�o deveria lan�a exce��o");
		}
		try{
			this.agenda.pesquisarContato("gilson");
			fail("Deveria ter lan�ado a exce��o");
		}catch(ContatoInexistenteException e){
			//OK
		}
	}
	@Test
	public void pesquisaContatoTest(){
		this.agenda.adicionarContato("gilson","222");
		try{
			assertEquals("gilson",this.agenda.pesquisarContato("gilson").getNome());
			assertEquals("222",this.agenda.pesquisarContato("gilson").getTelefone());
			//OK
		}catch(ContatoInexistenteException e){
			fail("n�o deveria lan�a a exce��o");
		}
		try {
			this.agenda.removerContato("gilson");
		} catch (ContatoInexistenteException e) {
			fail("n�o deveria lan�a a exce��o");
		}
		try{
			this.agenda.pesquisarContato("gilson");
			fail("n�o deveria lan�a a exce��o");
		}catch(ContatoInexistenteException e){
			//OK
		}
	}
	@Test
	public void getContatosTest(){
		this.agenda.adicionarContato("gilson","222");
		this.agenda.adicionarContato("italo","333");
		this.agenda.adicionarContato("zeze","555");
		List<Contato> list = new ArrayList<Contato>();
		list.addAll(this.agenda.getContatos());
		Contato c = list.get(0);
		assertEquals("zeze",c.getNome());
		assertEquals("555",c.getTelefone());
	}
	@Test
	public void getContatosOrdenados(){
		this.agenda.adicionarContato("gilson","222");
		this.agenda.adicionarContato("alisson","444");
		Iterator<Contato> i = this.agenda.getContatosOrdenados();
		boolean achou = true;
		while(i.hasNext()){
			Contato c = i.next();
			if(achou){
				assertEquals("alisson",c.getNome());
				assertEquals("444",c.getTelefone());
				achou = false;
			}
		}
	}
	@Test(expected = ContatoInexistenteException.class)
	public void addMapTest() throws ContatoExistenteException, ContatoInexistenteException{
		this.agenda.adicionarContatoMap(new Contato("gilson","919191919"));
		this.agenda.adicionarContatoMap(new Contato("gilson","818181818"));
		assertEquals("919191919",this.agenda.pesquisarContato("gilson").getTelefone());
	}
	@Test(expected = ContatoInexistenteException.class)
	public void removerContatoTest() throws ContatoInexistenteException, ContatoExistenteException{
		this.agenda.adicionarContatoMap(new Contato("gilson","919191919"));
		this.agenda.removerContato("gilson");
		assertNull(this.agenda.pesquisarContato("gilson"));
	}
	@Test(expected = ContatoInexistenteException.class)
	public void pesquisaContato() throws ContatoExistenteException, ContatoInexistenteException{
		this.agenda.adicionarContatoMap(new Contato("gilson","1919191919"));
		assertEquals("gilson",this.agenda.pesquisarContato("gilson").getNome());
	}
	@Test(expected = ContatoInexistenteException.class)
	public void salvaTest() throws ContatoExistenteException, ContatoInexistenteException{
		this.agenda.adicionarContatoMap(new Contato("gilson","91512643"));
		this.agenda.gravaContatos();
		AgendaMap m = new AgendaMap();
		assertNull(m.pesquisarContato("gilson"));
	}
	@Test
	public void getContatosOrdenadosTest() throws ContatoExistenteException{
		this.agenda.adicionarContatoMap(new Contato("alisson","818181818"));
		
	}
}

