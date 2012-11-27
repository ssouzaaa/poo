package Exercicio8;

import java.util.*;
import java.io.*;

public class GravadorDeContatosMap{

	public GravadorDeContatosMap(){
	}
	@SuppressWarnings("unchecked")
	public Map<String, Contato> leContato() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatosMap.txt"));
			return (HashMap<String, Contato>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo nao encontrado",e);
		}catch(ClassNotFoundException e){
			throw new IOException("Classe nao encontrada",e);
		}catch(IOException e){
			throw e;
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaContatos(Map <String, Contato> pedidos)throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatosMap.txt"));
			out.writeObject(pedidos);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo nao encontrado", e);
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}


