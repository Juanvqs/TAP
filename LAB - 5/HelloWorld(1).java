import java.io.*;
import java.util.*;
import java.util.Comparator;

public class HelloWorld {
    
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
	
	public int getBloco(){

		return this.bloco;
	}
	public String getDescricao(){

		String ans = "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + (this.acessivel == true ? "acessivel)" : "nao acessivel)") ;

		return ans;
	}

	public static Comparator<HelloWorld> tuNameComparator = new Comparator<HelloWorld>() {

	public int compare(HelloWorld s1, HelloWorld s2) {

	   int a = s1.capacidade;
	   int b = s2.capacidade;

	   //ascending order
	   if(a < b) return -1;
	   else if(a > b) return 1;
	   else return 0;

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};
	
    public static void main(String[] args) {
        /*Collections.sort(Database.arrayList, 
                        (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));*/
                        
        ArrayList<HelloWorld> x = new ArrayList<HelloWorld>();
        
        HelloWorld teste = new HelloWorld(10,202,60,true);
        HelloWorld teste1 = new HelloWorld(2,204,59,true);
        HelloWorld teste2 = new HelloWorld(6,206,60,true);
        HelloWorld teste3 = new HelloWorld(1,208,2,true);
        
        x.add(teste);
        x.add(teste1);
        x.add(teste2);
        x.add(teste3);

        Collections.sort(x,HelloWorld.tuNameComparator);

        Iterator<HelloWorld> it = x.iterator();
        HelloWorld ans = it.next();


        for(HelloWorld str: x){

			System.out.println(str.bloco);
	   }
    }

}