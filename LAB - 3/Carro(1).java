public class Carro{

	String marca;
	String modelo;
	Proprietario proprietario;
	Placa placa;
	Motor motor;

	Carro(String marca, String modelo, Proprietario proprietario, Placa placa, Motor motor){
		this.marca = marca;
		this.modelo = modelo;
		this.proprietario = proprietario;
		this.placa = placa;
		this.motor = motor;
	}

	public String getDescricao(){

		String descricao = "Carro " + this.marca + "/" + this.modelo + ". Proprietario: nome=" + this.proprietario.nome + ", cnh=" + this.proprietario.cnh +
		", anoNascimento=" + this.proprietario.anoNascimento + ". Placa: placa=" + this.placa.placa + ", tipo=" + this.placa.getTipoString() + 
		", estacionamentoLivre=" + this.placa.temEstacionamentoLivre() + ". Motor: tipo=" + this.motor.getTipoString() + ", capacidade=" + 
		this.motor.capacidade + "L, potencia=" + this.motor.potencia + "CV.";

		return descricao;
	}

	public static void main(String[] args) {
		
		Carro ans;
		Proprietario p = new Proprietario("Emmett L. Brown", 98008173, 1920);
		Placa l = new Placa("OAT-3966", 6);
		Motor k = new Motor(1, 2.82, 130);


		ans = new Carro("DeLorean","DMC-12", p, l, k);

		System.out.println(ans.getDescricao());
	}

}