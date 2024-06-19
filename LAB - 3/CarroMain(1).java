public class CarroMain{

	public static void main(String[] args){

		Carro ans;
		Proprietario p = new Proprietario("Emmett L. Brown", 98008173, 1920);
		Placa l = new Placa("OAT-3966", 6);
		Motor k = new Motor(1, 2.82, 130);


		ans = new Carro("DeLorean","DMC-12", p, l, k);

		System.out.println(ans.getDescricao());
	}
}