//package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.*;

public class Celular implements Localizavel{

	private int codPais, codArea, numero;

	public Celular(int codPais, int codArea, int numero){

		this.setCodPais(codPais);
		this.setCodArea(codArea);
		this.setNumero(numero);
	}

	public final void setCodPais(int codPais){

		if(codPais >= 1 && codPais <= 1999){

			this.codPais = codPais;
		}
		else{
			this.codPais = -1;
		}
	}
	public final void setCodArea(int codArea){

		if(codArea >= 10 && codArea <= 99){

			this.codArea = codArea;
		}
		else{
			this.codArea = -1;
		}
	}
	public final void setNumero(int numero){

		if(numero >= 10000000 && numero <= 999999999){

			this.numero = numero;
		}
		else{
			this.numero = -1;
		}
	}

	public int getCodPais(){

		return this.codPais;
	}
	public int getCodArea(){

		return this.codArea;
	}
	public int getNumero(){

		return this.numero;
	}

	public Posicao getPosicao(){

		Random r = new Random();
		double latitude = (-3.160000) + (-2.960000 - (-3.160000)) * r.nextDouble();
		double longitude = (-60.120000) + (-59.820000 - (-60.120000)) * r.nextDouble();
		double altitude = 15.0 + (100.0 - (15.0)) * r.nextDouble();

		Posicao x =  new Posicao(latitude, longitude, altitude);

		return x;
	}

	public double getErroLocalizacao(){

		return 50.0;
	}
}