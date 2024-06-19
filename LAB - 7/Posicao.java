//package br.edu.ufam.icomp.lab_encapsulamento;

public class Posicao{

	public Posicao(double latitude, double longitude, double altitude){

		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setAltitude(altitude);
	}

	private double latitude;
	private double longitude;
	private double altitude;

	public void setLatitude(double latitude){

		this.latitude = latitude;
	}
	public void setLongitude(double longitude){

		this.longitude = longitude;
	}

	public void setAltitude(double altitude){

		this.altitude = altitude;
	}


	public double getLatitude(){

		return this.latitude;
	}
	public double getLongitude(){

		return this.longitude;
	}
	public double getAltitude(){

		return this.altitude;
	}

	public String toString(){

		return "Posição: " + this.getLatitude() +", "+ this.getLongitude() +", "+ this.getAltitude();
	}

}