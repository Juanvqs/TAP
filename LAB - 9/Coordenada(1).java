//package br.edu.ufam.icomp.lab_excecoes;


public class Coordenada{

	private int posX;
	private int posY;
	private int digito;

	public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException{

		if(posY < 0 || posX < 0) throw new CoordenadaNegativaException();
		else if(posY < 0 || posY > 30000 || posX < 0 || posX > 30000) throw new CoordenadaForaDosLimitesException();
		else if(((posY + posX) % 10) != digito || ((posY + posX) % 10) != digito) throw new DigitoInvalidoException();

		this.posX = posX;
		this.posY = posY;
		this.digito = digito;
	}

	public int getPosX(){

		return this.posX;
	}

	public int getPosY(){

		return this.posY;
	}

	public double distancia(Coordenada coordenada){

		return Math.sqrt(((coordenada.getPosX() - this.getPosX()) * (coordenada.getPosX() - this.getPosX())) + ((coordenada.getPosY() - this.getPosY()) * (coordenada.getPosY() - this.getPosY())));

	}
	public String toString(){

		String coor = "" + this.getPosX() + ", " + this.getPosY();

		return coor;
	}

}