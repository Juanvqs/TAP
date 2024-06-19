import java.util.*;

public class GoogleMain{

	public static void main(String[] args) {
		
		ListaInvertida l = new ListaInvertida();
		l.insere("remember", "document1.txt");
		LinkedList d = l.busca("remember");
		l.insere("the", "document1.txt");
		System.out.println(l.insere("the", "document2.txt"));


		if(l.busca("avegn") == null){

			System.out.println("tem não, macho.");
		}

		System.out.println(l.toString());
	}
}