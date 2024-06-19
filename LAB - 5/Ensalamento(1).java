import java.io.*;
import java.util.*;


public class Ensalamento{

	ArrayList<Sala> salas = new ArrayList<Sala>();
	ArrayList<Turma> turmas = new ArrayList<Turma>();
	ArrayList<TurmaEmSala> ensalamento = new ArrayList<TurmaEmSala>();

	Ensalamento(){}

	public void addSala(Sala sala){

		this.salas.add(sala);
	}

	public void addTurma(Turma turma){

		this.turmas.add(turma);
	}

	public Sala getSala(Turma turma){

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			if(turma.nome == x.turma.nome && turma.professor == x.turma.professor && turma.numAlunos == x.turma.numAlunos && turma.acessivel == x.turma.acessivel){

				return x.sala;
			}
		}

		return null;
	}

	public boolean salaDisponivel(Sala sala, int horario){

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			if(sala.bloco == x.sala.bloco && sala.sala == x.sala.sala && sala.capacidade == x.sala.capacidade && sala.acessivel == x.sala.acessivel){

				if(x.turma.horarios.indexOf(horario) != -1){

					return false;
				}
			}
		}


		return true;
	}


	public boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios){

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			if(sala.bloco == x.sala.bloco && sala.sala == x.sala.sala && sala.capacidade == x.sala.capacidade && sala.acessivel == x.sala.acessivel){

				Iterator<Integer> it = horarios.iterator();

				while(it.hasNext()){

					Integer y = it.next();

					if(this.salaDisponivel(x.sala, y) == false){

						return false;
					}
				}
			}
		}


		return true;
	}



	public boolean alocar(Turma turma, Sala sala){

		if(((turma.acessivel == true && sala.acessivel == true) || (turma.acessivel == false && (sala.acessivel == true || sala.acessivel == false))) && (turma.numAlunos <= sala.capacidade) && (this.salaDisponivel(sala, turma.horarios))){

			TurmaEmSala nova = new TurmaEmSala(turma,sala);
			this.ensalamento.add(nova);
			return true;
		}
		else{

			return false;
		}

	}

	public static Comparator<Sala> comparatorSalas = new Comparator<Sala>() {

	public int compare(Sala s1, Sala s2) {

	   int a = s1.capacidade;
	   int b = s2.capacidade;

	   if(a < b) return -1;
	   else if(a > b) return 1;
	   else return 0;

    }};


    public static Comparator<Sala> comparatorSalas2 = new Comparator<Sala>() {

	public int compare(Sala s1, Sala s2) {

	   int a = s1.sala;
	   int b = s2.sala;

	   if(a < b) return -1;
	   else if(a > b) return 1;
	   else return 0;

    }};

    public static Comparator<Turma> comparatorTurmas = new Comparator<Turma>() {

	public int compare(Turma s1, Turma s2) {

	   int a = s1.numAlunos;
	   int b = s2.numAlunos;

	   if(a < b) return -1;
	   else if(a > b) return 1;
	   else return 0;

    }};

    public static Comparator<TurmaEmSala> comparatorEnsalamento = new Comparator<TurmaEmSala>() {

	public int compare(TurmaEmSala s1, TurmaEmSala s2) {

	   int a = s1.sala.sala;
	   int b = s2.sala.sala;

	   if(a < b) return -1;
	   else if(a > b) return 1;
	   else{

	   	if(s1.turma.numAlunos < s2.turma.numAlunos) return -1;
	   	else if (s1.turma.numAlunos > s2.turma.numAlunos) return -1;
	   	else return 0;

	   }

    }};

	public void alocarTodas(){

		Collections.sort(this.salas, Ensalamento.comparatorSalas);

		Collections.sort(this.turmas, Ensalamento.comparatorTurmas);

		   for (Sala x: this.salas){
		   		
		   		for (Turma y: this.turmas ) {
		   			
		   			if(this.getSala(y) == null){
		   				this.alocar(y,x);
		   			}
		   		}
		   	
		   }

	}




	public int getTotalTurmasAlocadas(){

		int ans = 0;

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			if(x.sala != null){

				ans++;
			}
		}

		return ans;

	}

	public int getTotalEspacoLivre(){

		int ans = 0;

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			ans += (x.sala.capacidade - x.turma.numAlunos);
		}

		return ans;

	}

	public String relatorioResumoEnsalamento(){

		String resumo = "Total de Salas: " + this.salas.size() + "\nTotal de Turmas: " + this.turmas.size() + "\nTurmas Alocadas: " + this.getTotalTurmasAlocadas() + "\nEspaços Livres: " + this.getTotalEspacoLivre() + "\n";
	
		return resumo;
	}

	public String relatorioTurmasPorSala(){


		Collections.sort(this.ensalamento, Ensalamento.comparatorEnsalamento);

		String relatorio = "" + this.relatorioResumoEnsalamento() + "\n";

		Iterator<TurmaEmSala> tm = this.ensalamento.iterator();

		boolean kk = false;

		if(this.ensalamento.size() == 1){

			TurmaEmSala w = tm.next();	
			
			int ll = w.sala.sala;

			relatorio +="--- " + w.sala.getDescricao() + " ---\n\n";

			relatorio += w.turma.getDescricao() +"\n\n";
		}
		else if(this.ensalamento.size() > 1){

			ArrayList<Sala> vld =  new ArrayList<Sala>();

			while(tm.hasNext()){

				TurmaEmSala w = tm.next();

				if(vld.indexOf(this.getSala(w.turma)) == -1){
					
					vld.add(this.getSala(w.turma));
					
					relatorio +="--- " + w.sala.getDescricao() + " ---\n\n";

					relatorio += w.turma.getDescricao() +"\n\n";
				}
				else{
					relatorio += w.turma.getDescricao() + "\n\n";
				}

			}

		}

		boolean flag = false;

		Collections.sort(this.salas, Ensalamento.comparatorSalas2);

		Iterator<Sala> it = this.salas.iterator();

		while(it.hasNext()){

			Sala k = it.next();
			
			//iterator = this.ensalamento.iterator();
			Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

			while(iterator.hasNext()){

				TurmaEmSala x = iterator.next();

				if(k.bloco == x.sala.bloco && k.sala == x.sala.sala && k.capacidade == x.sala.capacidade && k.acessivel == x.sala.acessivel){
					
					flag = true;
				}
			}

			if(flag == false){

				relatorio+="--- " + k.getDescricao() + " ---\n\n" ;
			}

			flag = false;
			
		}
		
		relatorio = relatorio.substring(0, relatorio.length() - 1);

		return relatorio;
	}

	public String relatorioSalasPorTurma(){

		String relatorio = "" + this.relatorioResumoEnsalamento() +"\n";

		Iterator<TurmaEmSala> iterator = this.ensalamento.iterator();

		while(iterator.hasNext()){

			TurmaEmSala x = iterator.next();

			relatorio += x.turma.getDescricao() + "\n";
			relatorio += "Sala: " + x.sala.getDescricao() + "\n\n";

		}

		boolean flag = false;

		Iterator<Turma> it = this.turmas.iterator();

		while(it.hasNext()){

			Turma k = it.next();
			
			iterator = this.ensalamento.iterator();

			while(iterator.hasNext()){

				TurmaEmSala x = iterator.next();

				if(k.nome == x.turma.nome && k.professor == x.turma.professor && k.numAlunos == x.turma.numAlunos && k.acessivel == x.turma.acessivel){
					
					flag = true;
				}
			}

			if(flag == false){

				relatorio+=k.getDescricao() + "\n";
				relatorio+="Sala: SEM SALA";
			}

			flag = false;
			
		}
		
		return relatorio;
	}
	
}