package org.adaitw.generacion8va.catalogo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase encargada de almacenar nuestro catalogo y proporcionar los m�todos
 * necesarios para trabajar con el mismo
 * 
 * @author marys
 *
 */
public class Catalogo {
	private TreeMap<Integer, Capitulo> capitulos;
	private TreeMap<String, TreeMap<Integer, Capitulo>> catalogo;

	public Catalogo() throws FileNotFoundException {
		LectorArchivos lector = new LectorArchivos();
		this.capitulos = lector.getCapitulos();
		this.catalogo = lector.getCatalogo();
	}

	/*
	 * ***** SELECCIONAR LISTAS *****
	 */
	
	public TreeMap<Integer, Capitulo> seleccionarMapaCapitulosPorNivel(String nivel) {
		return catalogo.get(nivel);
	}

	public Collection<Capitulo> seleccionarListaCapitulosPorNivel(String nivel) {
		return seleccionarMapaCapitulosPorNivel(nivel).values();
	}

	public ArrayList<Concepto> seleccionarListaConceptos(int nroCap) {
		return seleccionarCapituloNro(nroCap).getConceptos();
	}

	public ArrayList<Ejemplo> seleccionarListaEjemplos(int nroCap, int nroCon) {
		return seleccionarConceptoNro(nroCap, nroCon).getEjemplos();
	}

	public ArrayList<Pregunta> seleccionarListaPreguntas(int nroCap, int nroCon) {
		return seleccionarConceptoNro(nroCap, nroCon).getPreguntas();
	}

	/*
	 * ***** SELECCIONAR ESPECIFICOS *****
	 */
	public Capitulo seleccionarCapituloNro(int nroCap) {
		return capitulos.get(nroCap);
	}

	public Concepto seleccionarConceptoNro(int nroCap, int nroCon) {
		return seleccionarCapituloNro(nroCap).seleccionarConceptoNro(nroCon);
	}

	public Ejemplo seleccionarEjemploNro(int nroCap, int nroCon, int nroEj) {
		return seleccionarConceptoNro(nroCap, nroCon).seleccionarEjemploNro(nroEj);
	}

	public Pregunta seleccionarPreguntaNro(int nroCap, int nroCon, int nroPreg) {
		return seleccionarConceptoNro(nroCap, nroCon).seleccionarPreguntaNro(nroPreg);
	}

	/*
	 * ***** SELECCIONAR ALEATORIOS *****
	 */
	public Capitulo seleccionarCapituloAleatorioPorNivel(String nivel) {
		Collection<Capitulo> lista = seleccionarListaCapitulosPorNivel(nivel);
		Object[] arr = lista.toArray();

		// Definir el rango
		int max = arr.length;
		int min = 0;
		int range = max - min;
		int nroRandom = (int) (Math.random() * range) + min;

		return (Capitulo) arr[nroRandom];
	}

	public Concepto seleccionarConceptoAleatorioPorNivel(String nivel) {
		Capitulo cap = seleccionarCapituloAleatorioPorNivel(nivel);
		try {
			return cap.seleccionarConceptoAleatorio();
		} catch (Exception e) {
			System.out.print(cap + ": " + e.getMessage());
			System.out.println();
		}
		return null;
	}

	public Pregunta seleccionarPreguntaAleatoriaPorNivel(String nivel) {
		Capitulo cap = seleccionarCapituloAleatorioPorNivel(nivel);
		Concepto con = cap.seleccionarConceptoAleatorio();
		return con.seleccionarPreguntaAleatoria();
	}

	public Ejemplo seleccionarEjemploAleatorioPorNivel(String nivel) {
		Capitulo cap = seleccionarCapituloAleatorioPorNivel(nivel);
		Concepto con = cap.seleccionarConceptoAleatorio();
		return con.seleccionarEjemploAleatorio();
	}

	/*
	 * ***** METODOS AUXILIARES *****
	 */

	/*
	 * ***** MOSTRAR LISTAS *****
	 * 
	 * PASAR A MENSAJES <--
	 */
	public void mostrarConceptosDelCapitulo(int nroCap) {
		ArrayList<Concepto> lista = seleccionarListaConceptos(nroCap);
		for (Concepto c : lista) {
			if (c != null) {
				System.out.println(c);
			}
		}
	}

	public void mostrarCapitulosPorNivel(String nivel) {
		Collection<Capitulo> lista = seleccionarListaCapitulosPorNivel(nivel);

		for (Capitulo cap : lista) {
			int nroCap = cap.getNroCapitulo();
			System.out.printf("Capitulo %d: %s\n", nroCap, cap.getNombre());
		}
	}

	public void mostrarIndiceCompleto() {
		// variables auxiliares
		Map.Entry<Integer, Capitulo> entry;
		Capitulo cap;
		ArrayList<Concepto> conceptos;

		// recorro capitulos y muestro sus conceptos
		Iterator<Map.Entry<Integer, Capitulo>> itr = capitulos.entrySet().iterator();

		while (itr.hasNext()) {
			entry = itr.next();
			cap = entry.getValue();
			conceptos = cap.getConceptos();
			System.out.println("**********************************");
			System.out.println(cap);
			for (Concepto c : conceptos) {
				if (c != null) {
					System.out.println("_______________________________");
					System.out.println("  " + c);
					System.out.println();
					System.out.println("  " + c.getTeoria());
					System.out.println("-------------------------------");
					for(Pregunta p : c.getPreguntas()) {
						System.out.println("  " + p);
						System.out.println("-------------------------------");
					}
					for(Ejemplo e : c.getEjemplos()) {
						System.out.println("  " + e);
						System.out.println();
					}
				}
			}
		}
		System.out.println();
	}

	public TreeMap<Integer, Capitulo> getCapitulos() {
		return capitulos;
	}

	public TreeMap<String, TreeMap<Integer, Capitulo>> getCatalogo() {
		return catalogo;
	}

	/*
	 * ***** MOSTRAR ESPECIFICOS *****
	 * 
	 */

}
