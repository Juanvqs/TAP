import java.util.*;

public class ListaInvertida{

	private Hashtable<String, LinkedList<String>> tabela;// = new Hashtable<String, LinkedList<String>>();

	public ListaInvertida(){

		Hashtable<String, LinkedList<String>> x = new Hashtable<String, LinkedList<String>>();
		this.setTabela(x);
	}

	public void setTabela(Hashtable<String, LinkedList<String>> tabela){

		this.tabela = tabela;
	}
	public Hashtable<String, LinkedList<String>> getTabela(){

		return this.tabela;
	}

	public boolean insere(String palavra, String documento){

		LinkedList<String> lista =(LinkedList<String>) this.getTabela().get(palavra);

		if(lista != null){

			if(!lista.contains(documento)){

				((LinkedList<String>)this.getTabela().get(palavra)).add(documento);
				
				return true;
			}
			else{

				return false;
			}
		}
		else{
			LinkedList<String> nova = new LinkedList<String>();

			nova.add(documento);

			this.getTabela().put(palavra, nova);

			return true;
		}
	}

	public LinkedList<String> busca(String palavra){

		return ((LinkedList<String>)this.getTabela().get(palavra));
	}

	public String toString(){

		return this.getTabela().toString();
	}

	

}