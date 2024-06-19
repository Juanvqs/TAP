//package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.*;

public class GISMain{

	public static void main(String[] args) {
		
		Localizavel x = new CarroLuxuoso("XQO - 098");
		Localizavel y = new Celular(55, 15, 10000005);
		Localizavel localizaveis[] = new Localizavel[2];
		localizaveis[0] = x;
		localizaveis[1] = y;

		for(Localizavel localizavel : localizaveis){

				System.out.println(localizavel.getPosicao());
		}	
	}
}