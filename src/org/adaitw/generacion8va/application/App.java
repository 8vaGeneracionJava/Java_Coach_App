package org.adaitw.generacion8va.application;

import org.adaitw.generacion8va.catalogo.Catalogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Catalogo catalogo = new Catalogo();
		
		String separador = "*******************************************";

		// INDICE CATALOGO COMPLETO
		// catalogo.mostrarIndiceCompleto();

		Scanner read = new Scanner(System.in);
		// MEN� INICIAL
		// Ac� ir� un m�todo que muestre el mensaje de bienvenida
		System.out.print("Bienvenido/a a Java Coach App! \nA continuaci�n ingrese su nombre: \n");
		String nombre = read.nextLine();
		System.out.print("Por favor ingrese su correo electronico:\n");
		String mail = read.nextLine();
		System.out.println(separador);


		// Seleccion nivel
		System.out.printf(
				"Hola %s! \nAhora vamos a definir tu nivel de conocimientos: \n 1- Elegir mi nivel\n 2- Evaluar mi conocimiento actual\n",
				nombre);
		int opcion = read.nextInt();
		System.out.println(separador);

		int nivel;
		switch (opcion) {
		case 1:
			System.out.println("Elija una de las opciones: \n 1- B�sico \n 2- Intermedio \n 3- Avanzado");
			nivel = read.nextInt();
			break;
		case 2:
			// Puse 1 como ejemplo pero ac� ir� el m�todo que nos permita evaluar el
			// conocimiento y retorne el nivel
			System.out.println("Opci�n no disponible por el momento D:");
			nivel = 1;
			break;
		default:
			nivel = 1;
			break;
		}
		System.out.println(separador);
		
		// Creacion usuario
		User usuario = new User(nombre, nivel, mail);
		String nivelStr = usuario.nivelUsuarioAString();

		// MEN� ACTIVIDADES
		// Se repite hasta q se ingrese 0
		int actividad;
		do {
			System.out.printf("�Qu� te gustar�a hacer hoy, %s?\n", usuario.getNombre());
			System.out.print(
					"1- Estudiar un concepto espec�fico \n2- Estudiar temas aleatorios \n3- Subir de nivel de dificultad\n0- Salir\n");
			actividad = read.nextInt();
			System.out.println(separador);

			switch (actividad) {
			case 1:
				// 1- Estudiar un concepto espec�fico
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
				System.out.println("Opci�n no disponible por el momento D:");
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
