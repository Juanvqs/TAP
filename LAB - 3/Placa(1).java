public class Placa{

	String placa;
	int tipo;

	Placa(){}

	Placa(String placa, int tipo){

		this.placa = placa;
		this.tipo = tipo;
	}

	public String getTipoString(){

		String placa = "";

		switch(this.tipo){
			case 1:
				placa = "Normal";
				break;
			case 2:
				placa = "Servico";
				break;
			case 3:
				placa = "Oficial";
				break;
			case 4:
				placa = "Auto Escola";
				break;
			case 5:
				placa = "Prototipo";
				break;
			case 6:
				placa = "Colecionador";
				break;
			default:
				placa = "Outros";
				break;

		}

		return placa;
	}

	public boolean temEstacionamentoLivre(){

		return (this.tipo == 2 || this.tipo == 3) ?  true : false;
	}

	public String getDescricao(){

		String descricao = "Placa: placa=" + this.placa + ", tipo=" + this.getTipoString() + ", estacionamentoLivre=" + this.temEstacionamentoLivre() + ".";

		return descricao;
	}

	
}