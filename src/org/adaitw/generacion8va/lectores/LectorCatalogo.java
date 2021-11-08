package org.adaitw.generacion8va.lectores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.adaitw.generacion8va.catalogoTeoria.Capitulo;

public class LectorCatalogo {

	public static LinkedList<Capitulo> leerCapitulos() throws FileNotFoundException {
		
		LinkedList<Capitulo> capitulos = new LinkedList<Capitulo>();
		
		// creamos el archivo con su ruta
		File archivo = new File("catalogoInput2/capitulos.in");
		// creamos el scanner con ese archivo
		Scanner sc = new Scanner(archivo);
		
		// recorremos el archivo mientras que el lector encuentre una siguiente linea
		while(sc.hasNext()) {
			
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
			
			// a�adimos el capitulo a nuestra coleccion
			capitulos.add(cap);
			
		}
		
		// cerramos el lector
		sc.close();
		return capitulos;
	}

	public static void leerConceptos() {

	}

	public static void leerEjemplos() {

	}
	
	public static void leerPreguntas() {

	}
}
