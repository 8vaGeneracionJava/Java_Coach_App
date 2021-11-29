package org.adaitw.generacion8va.catalogo;

import java.util.ArrayList;

public class Concepto {
	private int nroCapitulo;
	private int nroConcepto;
	private String nombre;
	private String teoria;
	private ArrayList<Pregunta> preguntas;
	private ArrayList<Ejemplo> ejemplos;

	public Concepto(int nroCapitulo, int nroConcepto, String nombre, String teoria) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nroConcepto = nroConcepto;
		this.nombre = nombre;
		this.teoria = teoria;
		this.preguntas = new ArrayList<Pregunta>();
		this.ejemplos = new ArrayList<Ejemplo>();
	}

	public void agregarPregunta(Pregunta pregunta, int nroPregunta) {
		this.preguntas.add(pregunta);
	}

	public void agregarEjemplo(Ejemplo ejemplo, int nroEjemplo) {
		this.ejemplos.add(ejemplo);
	}

	public Pregunta seleccionarPreguntaNro(int nroPregunta) {
		return this.preguntas.get(nroPregunta);
	}

	public Ejemplo seleccionarEjemploNro(int nroEjemplo) {
		return this.ejemplos.get(nroEjemplo);
	}

	public Pregunta seleccionarPreguntaAleatoria() {
		// Definir el rango
		int max = preguntas.size();
		if (max == 1) {
			throw new RuntimeException("No hay preguntas en este concepto.");
		}
		int min = 1;
		int range = max - min;
		int nroPregunta = (int) (Math.random() * range) + min;

		return seleccionarPreguntaNro(nroPregunta);
	}

	public Ejemplo seleccionarEjemploAleatorio() {
		// Definir el rango
		int max = ejemplos.size();
		if (max == 1) {
			throw new RuntimeException("No hay ejemplos en este concepto.");
		}
		int min = 1;
		int range = max - min;
		int nroEjemplo = (int) (Math.random() * range) + min;

		return seleccionarEjemploNro(nroEjemplo);
	}

	// region GETTERS y SETTERS
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

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public ArrayList<Ejemplo> getEjemplos() {
		return ejemplos;
	}
	// endregion

	@Override
	public String toString() {
		return String.format("%02d-%s", nroConcepto, nombre);
	}

	public void mostrarTeoria() {
		System.out.println(this);
		System.out.println("----------------------------------");
		System.out.println(this.teoria);
		System.out.printf("[Cap�tulo %02d | Concepto %02d]\n\n", this.nroCapitulo, this.nroConcepto);

	}

}
