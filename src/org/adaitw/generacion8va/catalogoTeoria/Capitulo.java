package org.adaitw.generacion8va.catalogoTeoria;

import java.util.LinkedList;

public class Capitulo {
	private int nroCapitulo;
	private LinkedList<Concepto> conceptos;
	private String dificultad;

	public Capitulo(int nroCapitulo, String dificultad) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.conceptos = new LinkedList<Concepto>();
		this.dificultad = dificultad;
	}

	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public LinkedList<Concepto> getConceptos() {
		return conceptos;
	}

	public String getDificultad() {
		return dificultad;
	}

}
