package org.adaitw.generacion8va.application;

import org.adaitw.generacion8va.catalogo.Catalogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Catalogo catalogo = new Catalogo();
		
		String separador = "*******************************************";

		Scanner read = new Scanner(System.in);
		// INDICE CATALOGO COMPLETO
		System.out.println("Mostrar catalogo completo? y/n");
		if(read.nextLine().equalsIgnoreCase("y")) {
			catalogo.mostrarIndiceCompleto();			
		}

		// MENÚ INICIALS
		// Acá irá un método que muestre el mensaje de bienvenida
		System.out.print("Bienvenido/a a Java Coach App! \nA continuacin ingrese su nombre: \n");
		String nombre = read.nextLine();
		System.out.println(separador);

		// Seleccion nivel
		System.out.printf(
				"Hola %s! \nAhora vamos a definir tu nivel de conocimientos: \n 1- Elegir mi nivel\n 2- Evaluar mi conocimiento actua\n",
				nombre);
		int opcion = read.nextInt();
		System.out.println(separador);

		int nivel;
		switch (opcion) {
		case 1:
			System.out.println("Elija una de las opciones: \n 1- Básico \n 2- Intermedio \n 3- Avanzado");
			nivel = read.nextInt();
			break;
		case 2:
			// Puse 1 como ejemplo pero acá irá el método que nos permita evaluar el
			// conocimiento y retorne el nivel
			System.out.println("Opción no disponible por el momento D:");
			nivel = 1;
			break;
		default:
			nivel = 1;
			break;
		}
		System.out.println(separador);
		
		// Creacion usuario
		User usuario = new User(nombre, nivel);
		String nivelStr = usuario.nivelUsuarioAString();

		// MENÚ ACTIVIDADES
		// Se repite hasta q se ingrese 0
		int actividad;
		do {
			System.out.printf("¿Qué te gustaría hacer hoy, %s?\n", usuario.getNombre());
			System.out.print(
					"1- Estudiar un concepto específico \n2- Estudiar temas aleatorios \n3- Subir de nivel de dificultad\n0- Salir\n");
			actividad = read.nextInt();
			System.out.println(separador);

			switch (actividad) {
			case 1:
				// 1- Estudiar un concepto específico
				catalogo.mostrarCapitulosPorNivel(nivelStr);
				System.out.print("Elegir nro de Capitulo: ");
				int nroCap = read.nextInt();
				System.out.println();

				catalogo.mostrarConceptosDelCapitulo(nroCap);
				System.out.print("Elegir nro de Concepto: ");
				int nroCon = read.nextInt();
				System.out.println();

				(catalogo.seleccionarConceptoNro(nroCap, nroCon)).mostrarTeoria();
				break;
			case 2:
				// 2- Estudiar temas aleatorios
				// mostrarTeoriaAleatoriamente(nivel)
				try {
					catalogo.seleccionarConceptoAleatorioPorNivel(nivelStr).mostrarTeoria();
				} catch (Exception e) {

				}
				break;
			case 3:
				// 3- Subir de nivel de dificultad
				// tomarTestDeNivel()
				// Setear nuevo nivel o mantener el anterior
				System.out.println("Opción no disponible por el momento D:");
				break;
			case 0:
				System.out.printf("Chau %s!! Nos vemos! u3u\n", usuario.getNombre());
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
			System.out.println(separador);
		} while (actividad != 0);
		
		read.close();
	}

}
