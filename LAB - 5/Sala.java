public class Sala{

	int bloco;
	int sala;
	int capacidade;
	boolean acessivel;

	Sala(){
		this(0,0,0,false);
	}

	Sala(int bloco, int sala, int capacidade, boolean acessivel){

		this.bloco = bloco;
		this.sala = sala;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
	}

	public String getDescricao(){

		String ans = "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + (this.acessivel == true ? "acessível)" : "não acessível)") ;

		return ans;
	}

}