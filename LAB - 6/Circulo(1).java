//package br.edu.icomp.ufam.lab_heranca;

public class Circulo extends FormaGeometrica{

	public double raio;

	public Circulo(int posX, int posY, double raio){
		super(posX,posY);
		this.raio = raio;
	}

	public double getArea(){

		return Math.PI * this.raio * this.raio;
	}

	public double getPerimetro(){

		return 2 * Math.PI * this.raio;
	}

	public String toString(){

		String descricao = "Círculo na "+ this.getPosString() + " com raio de " + this.raio + "cm (área=" + this.getArea() + "cm2, perímetro=" + this.getPerimetro() + "cm)";
		return descricao;
	}

}