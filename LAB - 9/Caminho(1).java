//package br.edu.ufam.icomp.lab_excecoes;

public class Caminho{

	private Coordenada caminho[];
	private int tamanho;

	public Caminho(int maxTam){

		this.caminho = new Coordenada[maxTam];
		this.tamanho = 0;
	}
	public int tamanho(){

		return this.tamanho;
	}
	public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException{

		if(this.tamanho() == this.caminho.length) throw new TamanhoMaximoExcedidoException();
		else if(this.tamanho() >= 1){

			if(caminho[this.tamanho()-1].distancia(coordenada) > 15.0) throw new DistanciaEntrePontosExcedidaException();
		}

		this.caminho[this.tamanho++] = coordenada;
	}
	public void reset(){

		this.caminho = null;
	}
	public String toString(){

		String coor = "Dados do caminho:\n  - Quantidade de pontos: " + this.tamanho() + "\n  - Pontos:\n";

		for(int i = 0; i < this.tamanho(); i++){

			coor += "    -> " + this.caminho[i].toString() + "\n";
		}
		return coor;
	}

	
}