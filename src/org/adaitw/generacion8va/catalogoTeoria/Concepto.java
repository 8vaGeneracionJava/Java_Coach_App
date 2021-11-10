package org.adaitw.generacion8va.catalogoTeoria;

import java.util.LinkedList;

public class Concepto {
	private int nroCapitulo;
	private int nroConcepto;
	private String nombre;
	private String teoria;
	private LinkedList<Pregunta> preguntas; 
	private LinkedList<Ejemplo> ejemplos; 
	// private LinkedList<Concepto> subtemas;
	
	public Concepto(int nroCapitulo, int nroConcepto, String nombre, String teoria) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nroConcepto = nroConcepto;
		this.nombre = nombre;
		this.teoria = teoria;
		this.preguntas = new LinkedList<Pregunta>();
		this.ejemplos = new LinkedList<Ejemplo>();
	}

	public void agregarPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	
	public void agregarEjemplo(Ejemplo ejemplo) {
		this.ejemplos.add(ejemplo);
	}
	
	public int getNroCapitulo() {
		return nroCapitulo;
	}
	

	public int getNroConcepto() {
		return nroConcepto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTeoria() {
		return teoria;
	}

	public LinkedList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public LinkedList<Ejemplo> getEjemplos() {
		return ejemplos;
	}

	@Override
	public String toString() {
		return "nro " + nroConcepto + ": " + nombre ;
	}
	
}
