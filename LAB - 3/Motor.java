public class Motor {
	
	int tipo;
	double capacidade;
	int potencia;

	Motor(){}

	Motor(int tipo, double capacidade, int potencia){

		this.tipo = tipo;
		this.capacidade = capacidade;
		this.potencia = potencia;
	}

	public String getTipoString(){

		String motor;

		switch(this.tipo){
			case 1:
				motor = "Gasolina";
				break;
			case 2:
				motor = "Alcool";
				break;
			case 3:
				motor = "Flex";
				break;
			case 4:
				motor = "Diesel";
				break;
			case 5:
				motor = "Eletrico";
				break;
			default:
				motor = "Outros";
				break;
		}

		return motor;

	}

	public String getDescricao(){

		String descricao = "Motor: tipo=" + this.getTipoString() + ", capacidade=" + this.capacidade + "L, potencia=" + this.potencia + "CV.";

		return descricao;
	}

}