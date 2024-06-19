public class EnsalamentoMain{

	public static void main(String[] args) {
		
		Sala sala = new Sala(1000,101,70,true);
		Sala sala2 = new Sala(2000,201,100,false);
		Sala sala3 = new Sala(3000,301,50,true);
		Sala sala4 = new Sala(6,204,100,false);

		Turma turma = new Turma("Turma 1","Prof. 1", 60, true);
		Turma turma2 = new Turma("Laboratório de Programação C","Edson Nascimento",25,true);
		Turma turma3 = new Turma("Algoritmos e Estrutura de Dados I","Edleno Silva",60,false);
		Turma turma4 = new Turma("Redes de Computadores","Edjair Souza",50,false);
		Turma turma5 = new Turma("juraeussh","lebre",50,false);

		turma.horarios.add(2);
		turma.horarios.add(16);
		turma.horarios.add(30);

		turma2.horarios.add(1);
		turma2.horarios.add(15);
		turma2.horarios.add(29);

		turma3.horarios.add(1);
		turma3.horarios.add(15);
		turma3.horarios.add(29);

		turma4.horarios.add(1);
		turma4.horarios.add(15);
		turma4.horarios.add(29);

		turma5.horarios.add(3);
		turma5.horarios.add(17);
		turma5.horarios.add(25);

		Ensalamento ans = new Ensalamento();

		ans.addSala(sala);
		ans.addSala(sala2);
		ans.addSala(sala3);
		ans.addSala(sala4);
		ans.addTurma(turma);
		ans.addTurma(turma2);
		ans.addTurma(turma3);
		ans.addTurma(turma4);

		ans.alocar(turma4,sala3);

		ans.alocar(turma5,sala3);

		ans.alocar(turma,sala4);

		ans.alocarTodas();

		System.out.println(ans.relatorioTurmasPorSala());
		
		System.out.println(ans.relatorioSalasPorTurma());
	}

}