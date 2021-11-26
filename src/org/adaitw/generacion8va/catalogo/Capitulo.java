package org.adaitw.generacion8va.catalogo;

import java.util.ArrayList;

public class Capitulo {
	private int nroCapitulo;
	private String nombre;
	private ArrayList<Concepto> conceptos;
	private String dificultad;

	public Capitulo(int nroCapitulo, String nombre, String dificultad) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nombre = nombre;
		this.conceptos = new ArrayList<Concepto>();
		this.dificultad = dificultad;
	}

	public void agregarConcepto(Concepto concepto, int nroConcepto) {
		this.conceptos.add(concepto);
	}

	public Concepto seleccionarConceptoNro(int nroConcepto) {
		// return this.conceptos.get(nroConcepto);
		for(Concepto c : conceptos) {
			if (nroConcepto == c.getNroConcepto()){
				return c;
			}
		}
		return null;
	}

	public Concepto seleccionarConceptoAleatorio() {
		// define the range
		int max = conceptos.size();
		if (max == 1) {
			throw new RuntimeException("No hay conceptos en este capitulo.");
		}
		int min = 1;
		int range = max - min;
		int nroConcepto = (int) (Math.random() * range) + min;

		return seleccionarConceptoNro(nroConcepto);
	}

	// region GETTERS y SETTERS
	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}

	public String getDificultad() {
		return dificultad;
	}
	// endregion

	@Override
	public String toString() {
		return String.format("Capitulo %02d: %s", nroCapitulo, nombre);
	}

}
