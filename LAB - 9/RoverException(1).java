//package br.edu.ufam.icomp.lab_excecoes;

import java.util.*;
import java.lang.*;
public class RoverException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoverException(){

		this("Exceção geral do rover");
	}

	public RoverException(String s){

		super(s);
	}
}