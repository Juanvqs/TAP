import java.io.*;
import java.util.*;

class HelloWorld {
    
    int bloco;
	int sala;
	int capacidade;
	boolean acessivel;
	
	HelloWorld(){
		this(0,0,0,false);
	}

	HelloWorld(int bloco, int sala, int capacidade, boolean acessivel){

		this.bloco = bloco;
		this.sala = sala;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
	}
	
	public String getDescricao(){

		String ans = "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + (this.acessivel == true ? "acessivel)" : "nao acessivel)") ;

		return ans;
	}
	
    public static void main(String[] args) {
        /*Collections.sort(Database.arrayList, 
                        (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));*/
                        
        ArrayList<HelloWorld> x = new ArrayList<HelloWorld>();
        
        HelloWorld teste = new HelloWorld(2,202.60,true);
        HelloWorld teste1 = new HelloWorld(2,204.60,true);
        HelloWorld teste2 = new HelloWorld(2,206.60,true);
        HelloWorld teste3 = new HelloWorld(2,208.60,true);
        
        x.add(teste);
        x.add(teste1);
        x.add(teste2);
        x.add(teste3);
        
        System.out.println("Hello, World!"); 
    }

}