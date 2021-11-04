package org.adaitw.generacion8va.catalogoTeoria;

import java.util.LinkedList;

public class Capitulo {
	private int nroCapitulo;
	private String nombre;
	private LinkedList<Concepto> conceptos;
	private String dificultad;

	public Capitulo(int nroCapitulo, String nombre, String dificultad) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nombre = nombre;
		this.conceptos = new LinkedList<Concepto>();
		this.dificultad = dificultad;
	}

	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Concepto> getConceptos() {
		return conceptos;
	}

	public String getDificultad() {
		return dificultad;
	}

}
