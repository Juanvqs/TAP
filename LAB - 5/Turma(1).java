import java.io.*;
import java.util.*;

public class Turma {

	String nome;
	String professor;
	int numAlunos;
	boolean acessivel;
	ArrayList<Integer> horarios = new ArrayList<Integer>();

	Turma(){

		this("","",0,false);
	}

	Turma(String nome, String professor, int numAlunos, boolean acessivel){

		this.nome = nome;
		this.professor = professor;
		this.numAlunos = numAlunos;
		this.acessivel = acessivel;
	}

	public void addHorario(int horario){

		this.horarios.add(horario);
	}

	public String getHorariosString(){

		String hora = "";

		Hashtable<Integer,ArrayList<Integer>> tabela = new Hashtable<Integer, ArrayList<Integer>>();

		int x = 8;
        int y = 1;

        for (int i = 1; i <= 7 ; i++) {

        	y = i;

        	ArrayList<Integer> gfg = new ArrayList<Integer>();

        	for(int j = 0; j < 5; j++){

        		gfg.add(y);
        		y+=7;
        	}

        	tabela.put(x,gfg);
        	x+=2;
        }

        int first = 8;

        Iterator<Integer> iterator = this.horarios.iterator();

		while(iterator.hasNext()){

			Integer h = iterator.next();
			
			ArrayList<Integer> ans = tabela.get(first);

			if(ans.indexOf(h) != -1){

				switch(ans.indexOf(h)){
					case 0:
						hora+="segunda " + first + "hs, ";
						break;
					case 1:
						hora+="terça " + first + "hs, ";
						break;
					case 2:
						hora+="quarta " + first + "hs, ";
						break;
					case 3:
						hora+="quinta " + first + "hs, ";
						break;
					case 4:
						hora+="sexta " + first + "hs, ";

				}
			}
			else{

				while(ans.indexOf(h) == -1){

					first+=2;

					ans = tabela.get(first);

				}

				switch(ans.indexOf(h)){
					case 0:
						hora+="segunda " + first + "hs, ";
						break;
					case 1:
						hora+="terça " + first + "hs, ";
						break;
					case 2:
						hora+="quarta " + first + "hs, ";
						break;
					case 3:
						hora+="quinta " + first + "hs, ";
						break;
					case 4:
						hora+="sexta " + first + "hs, ";

				}
				first = 8;
			}
			
		}

		hora = hora.substring(0, hora.length() - 2);

		return hora;

	}

	public String getDescricao(){

		String descricao = "Turma: " + this.nome + "\n" + "Professor: " + this.professor + "\n" + "Número de Alunos: " + this.numAlunos + "\n" +
		"Horário: " + this.getHorariosString() + "\nAcessível: " + (this.acessivel == true ? "sim" : "não");


		return descricao;
	}

	public static void main(String[] args) {
		
		Turma x = new Turma("arr","edlenda",60,true);



		System.out.println(x.professor);
	}
}