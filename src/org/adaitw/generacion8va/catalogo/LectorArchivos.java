package org.adaitw.generacion8va.catalogo;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Clase que se ocupa de hacer el ingreso del material te�rico guardado en
 * archivos a la aplicaci�n
 */
public class LectorArchivos {

	private TreeMap<Integer, Capitulo> capitulos;

	public LectorArchivos() throws FileNotFoundException {
		super();
		this.capitulos = new TreeMap<Integer, Capitulo>();
		this.leerCapitulos();
		this.leerConceptos();
		this.leerPreguntas();
		this.leerEjemplos();
	}

	private void leerCapitulos() throws FileNotFoundException {
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/capitulos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// variables auxiliares
		String linea;
		String[] arrDatos;
		int nroCapitulo;
		String nombre;
		String nivel;
		Capitulo cap;

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			linea = sc.nextLine(); // "1;Fundamentos;Basico"

			// separamos la linea segun el separador en un array
			arrDatos = linea.split(";"); // ["1", "Fundamentos", "Basico"]

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			nroCapitulo = Integer.parseInt(arrDatos[0]);
			nombre = arrDatos[1];
			nivel = arrDatos[2];

			// creamos un nuevo capitulo con los datos obtenidos de la linea
			cap = new Capitulo(nroCapitulo, nombre, nivel);

			// actualizamos el mapa
			this.capitulos.put(nroCapitulo, cap);

		}

		// cerramos el lector
		sc.close();

	}

	private void leerConceptos() throws FileNotFoundException {

		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/conceptos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// variables auxiliares
		String linea;
		String[] arrDatos;
		int nroCapitulo;
		int nroConcepto;
		String nombre;
		String teoria;
		Concepto concept;

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			linea = sc.nextLine(); // "1;1;Atributos;Los atributos, tambien llamad..."

			// separamos la linea segun el separador en un array
			arrDatos = linea.split(";"); // ["1", "1", "Atributos", "Los atributos, tambien llamad..."]

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			nroCapitulo = Integer.parseInt(arrDatos[0]);
			nroConcepto = Integer.parseInt(arrDatos[1]);
			nombre = arrDatos[2];
			teoria = arrDatos[3].replace("\\n", "\n").replace("\\t", "\t");

			// creamos un nuevo capitulo con los datos obtenidos de la linea
			concept = new Concepto(nroCapitulo, nroConcepto, nombre, teoria);

			// a�adimos el concepto MODIFICAR PARA MEJOR LECTURA
			if (capitulos.containsKey(nroCapitulo)) {
				capitulos.get(nroCapitulo).agregarConcepto(concept, nroConcepto);
			}
		}

		// cerramos el lector
		sc.close();
	}

	private void leerPreguntas() throws FileNotFoundException {
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/preguntas.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// variables auxiliares
		String linea;
		String[] arrDatos;
		int nroCapitulo;
		int nroConcepto;
		int nroPregunta;
		String pregunta;
		int cantidadRespuestas;
		String[] respuestas;
		Pregunta preg;

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			linea = sc.nextLine();

			// separamos la linea segun el separador en un array
			arrDatos = linea.split(",");

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			nroCapitulo = Integer.parseInt(arrDatos[0]);
			nroConcepto = Integer.parseInt(arrDatos[1]);
			nroPregunta = Integer.parseInt(arrDatos[2]);
			pregunta = arrDatos[3];
			cantidadRespuestas = Integer.parseInt(arrDatos[4]);
			respuestas = new String[cantidadRespuestas];

			int contador = 0;
			for (int i = 5; i < (5 + cantidadRespuestas); i++) {
				respuestas[contador] = arrDatos[i];
				contador++;
			}

			int respuestaCorrecta = Integer.parseInt(arrDatos[arrDatos.length - 1]);

			// creamos un nuevo pregunta con los datos obtenidos de la linea
			preg = new Pregunta(nroCapitulo, nroConcepto, nroPregunta, pregunta, respuestas, respuestaCorrecta);

			// a�adimos la pregunta MODIFICAR PARA MEJOR LECTURA

			Capitulo cptlAux = capitulos.get(nroCapitulo);
			Concepto cptoAux = cptlAux.seleccionarConceptoNro(nroConcepto);
			if (cptoAux != null) {
				cptoAux.agregarPregunta(preg, nroPregunta);
			}
		}

		// cerramos el lector
		sc.close();
	}

	private void leerEjemplos() throws FileNotFoundException {
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/ejemplos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// variables auxiliares
		String linea;
		String[] arrDatos;
		int nroCapitulo;
		int nroConcepto;
		int nroEjemplo;
		String ejempStr;
		String descrip;
		Ejemplo ejemplo;

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			linea = sc.nextLine();

			// separamos la linea segun el separador en un array
			arrDatos = linea.split("X");

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			nroCapitulo = Integer.parseInt(arrDatos[0]);
			nroConcepto = Integer.parseInt(arrDatos[1]);
			nroEjemplo = Integer.parseInt(arrDatos[2]);
			ejempStr = arrDatos[3].replace("\\n", "\n");
			descrip = arrDatos[4].replace("\\n", "\n");

			// creamos un nuevo pregunta con los datos obtenidos de la linea
			ejemplo = new Ejemplo(nroCapitulo, nroConcepto, nroEjemplo, ejempStr, descrip);

			// a�adimos la pregunta MODIFICAR PARA MEJOR LECTURA
			Capitulo cptlAux = capitulos.get(nroCapitulo);
			Concepto cptoAux = cptlAux.seleccionarConceptoNro(nroConcepto);
			if (cptoAux != null) {
				cptoAux.agregarEjemplo(ejemplo, nroEjemplo);
			}

		}

		// cerramos el lector
		sc.close();
	}

	public TreeMap<Integer, Capitulo> getCapitulos() {
		return capitulos;
	}

	public TreeMap<String, TreeMap<Integer, Capitulo>> getCatalogo() {
		TreeMap<String, TreeMap<Integer, Capitulo>> catalogo = new TreeMap<String, TreeMap<Integer, Capitulo>>();
		// variables auxiliares
		Map.Entry<Integer, Capitulo> entry;
		int nroCap;
		Capitulo cap;
		String dificultad;
		TreeMap<Integer, Capitulo> valueAux;

		//
		Iterator<Map.Entry<Integer, Capitulo>> itr = capitulos.entrySet().iterator();

		while (itr.hasNext()) {
			entry = itr.next();
			nroCap = entry.getKey();
			cap = entry.getValue();
			dificultad = cap.getDificultad();
			if (catalogo.containsKey(dificultad)) {
				valueAux = catalogo.get(dificultad);
			} else {
				valueAux = new TreeMap<Integer, Capitulo>();
			}
			valueAux.put(nroCap, cap);

			// actualizamos el mapa
			catalogo.put(dificultad, valueAux);
		}
		return catalogo;
	}

}