package org.adaitw.generacion8va.catalogo;

import java.util.Arrays;

public class Ejemplo {
	private int nroCapitulo;
	private int nroConcepto;
	private int nroEjemplo;
	private String ejemplo;
	private String descripcion;
	
	public Ejemplo(int nroCapitulo, int nroConcepto, int nroEjemplo, String ejemplo, String descripcion) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nroConcepto = nroConcepto;
		this.nroEjemplo = nroEjemplo;
		this.ejemplo = ejemplo;
		this.descripcion = descripcion;
	}

	//region GETTERS y SETTERS 
	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public int getNroConcepto() {
		return nroConcepto;
	}

	public int getNroEjemplo() {
		return nroEjemplo;
	}

	public String getEjemplo() {
		return ejemplo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Ejemplo " + nroEjemplo + ": " + ejemplo + "\n" + descripcion;
	}	
	
	//endregion
}
