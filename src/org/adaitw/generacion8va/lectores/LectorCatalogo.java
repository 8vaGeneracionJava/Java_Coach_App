package org.adaitw.generacion8va.lectores;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.adaitw.generacion8va.catalogoTeoria.Capitulo;
import org.adaitw.generacion8va.catalogoTeoria.Concepto;
import org.adaitw.generacion8va.catalogoTeoria.Pregunta;

/**
 * 
 * 
 *
 */
public class LectorCatalogo {

	LinkedList<Capitulo> capitulos;

	public LectorCatalogo() throws FileNotFoundException {
		super();
		capitulos = new LinkedList<Capitulo>();
		this.leerCapitulos();
		this.leerConceptos();
		this.leerPreguntas();
	}

	public LinkedList<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void leerCapitulos() throws FileNotFoundException {
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/capitulos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			String linea = sc.nextLine(); // "1;Fundamentos;Basico"

			// separamos la linea segun el separador en un array
			String[] arrDatos = linea.split(";"); // ["1", "Fundamentos", "Basico"]

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			int nroCapitulo = Integer.parseInt(arrDatos[0]);
			String nombre = arrDatos[1];
			String nivel = arrDatos[2];

			// creamos un nuevo capitulo con los datos obtenidos de la linea
			Capitulo cap = new Capitulo(nroCapitulo, nombre, nivel);

			// añadimos el capitulo a nuestra coleccion
			capitulos.add(cap);

		}

		// cerramos el lector
		sc.close();

	}

	public void leerConceptos() throws FileNotFoundException {

		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/conceptos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			String linea = sc.nextLine(); // "1;1;Atributos;Los atributos, tambien llamad..."

			// separamos la linea segun el separador en un array
			String[] arrDatos = linea.split(";"); // ["1", "1", "Atributos", "Los atributos, tambien llamad..."]

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			int nroCapitulo = Integer.parseInt(arrDatos[0]);
			int nroConcepto = Integer.parseInt(arrDatos[1]);
			String nombre = arrDatos[2];
			String teoria = arrDatos[3].replace("\\n", "\n");

			// creamos un nuevo capitulo con los datos obtenidos de la linea
			Concepto con = new Concepto(nroCapitulo, nroConcepto, nombre, teoria);

			// añadimos el concepto
			for (Capitulo capitulo : capitulos) {
				if (capitulo.getNroCapitulo() == con.getNroCapitulo()) {
					capitulo.agregarConcepto(con);
					break;
				}
			}
		}

		// cerramos el lector
		sc.close();

	}

	public void leerPreguntas() throws FileNotFoundException {
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput/preguntas.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);

		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while (sc.hasNext()) {

			// guardamos la linea en un string
			String linea = sc.nextLine();

			// separamos la linea segun el separador en un array
			String[] arrDatos = linea.split(",");

			// parseamos los datos numericos y asignamos los datos a los parametros
			// que le vamos a pasar al constructor
			int nroCapitulo = Integer.parseInt(arrDatos[0]);
			int nroConcepto = Integer.parseInt(arrDatos[1]);
			int nroPregunta = Integer.parseInt(arrDatos[2]);
			String pregunta = arrDatos[3];
			int cantidadRespuestas = Integer.parseInt(arrDatos[4]);
			String[] respuestas = new String[cantidadRespuestas];

			int contador = 0;
			for (int i = 5; i < 5 + cantidadRespuestas; i++) {
				respuestas[contador] = arrDatos[i];
				contador++;
			}

			int respuestaCorrecta = Integer.parseInt(arrDatos[arrDatos.length - 1]);

			// creamos un nuevo pregunta con los datos obtenidos de la linea
			Pregunta preg = new Pregunta(nroCapitulo, nroConcepto, nroPregunta, pregunta, respuestas,
					respuestaCorrecta);

			// añadimos el concepto

			for (Capitulo capitulo : capitulos) {
				if (capitulo.getNroCapitulo() == preg.getNroCapitulo()) {
					LinkedList<Concepto> listaConceptos = capitulo.getConceptos();
					for (Concepto concepto : listaConceptos) {
						if (concepto.getNroConcepto() == preg.getNroConcepto()) {
							concepto.agregarPregunta(preg);
						}
					}
				}
			}
		}

		// cerramos el lector
		sc.close();
	}

	public void leerEjemplos() throws FileNotFoundException {

	}

}