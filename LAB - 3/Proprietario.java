public class Proprietario{

	String nome;
	int cnh;
	int anoNascimento;

	Proprietario(){}

	Proprietario(String nome, int cnh, int anoNascimento){
		this.nome = nome;
		this.cnh  = cnh;
		this.anoNascimento = anoNascimento;

	}

	public int getIdade(int anoReferencia){

		return anoReferencia - this.anoNascimento;
	}

	public String getDescricao(){

		String descricao = "Proprietario: nome=" + this.nome + ", cnh=" + this.cnh + ", anoNascimento="+this.anoNascimento +".";

		return descricao;
	}
}