//package br.edu.icomp.ufam.lab_heranca;

public class FormasMain{

	public static void main(String[] args) {

		FormaGeometrica x = new Retangulo(12,65,2,7);
		FormaGeometrica y = new Circulo(32,87,6);
		FormaGeometrica z = new Quadrado(45,39,6);
		FormaGeometrica formas[] = new FormaGeometrica[3];
		formas[0] = x;
		formas[1] = y;
		formas[2] = z;

		for(FormaGeometrica forma : formas){

			System.out.println(forma.toString());
		}
	}
}