//package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain{

	public static void main(String[] args) {
		
		Caminho c = new Caminho(6);

		try{
			Coordenada x = new Coordenada(32,30, 2);
			Coordenada y = new Coordenada(35,40,5);
			c.addCoordenada(x);
			c.addCoordenada(y);
			x = new Coordenada(38,30, 8);
			c.addCoordenada(x);
			System.out.println(c.toString());
		}
		catch(DigitoInvalidoException e){

			System.out.println(e.getMessage());

		}
		catch(TamanhoMaximoExcedidoException e){
			
			System.out.println(e.getMessage());

		}
		catch(DistanciaEntrePontosExcedidaException e){
			
			System.out.println(e.getMessage());

		}
		catch(CoordenadaNegativaException e){
			
			System.out.println(e.getMessage());

		}
		catch(CoordenadaForaDosLimitesException e){
			
			System.out.println(e.getMessage());

		}
	}
}