package org.adaitw.generacion8va.application.menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.adaitw.generacion8va.application.User;
import org.adaitw.generacion8va.application.mensajes.*;
import org.adaitw.generacion8va.catalogo.Catalogo;

public class Menu {

	public static void main(String[] args) throws FileNotFoundException {
		Catalogo catalogo = new Catalogo();

		Bienvenida bienvenida = new Bienvenida();
		// MENÚ INICIAL
		bienvenida.mensajeBienvenida();
		String nombre = bienvenida.nombreUser();

		Scanner read = new Scanner(System.in);
		System.out.printf("Hola %s! \nAhora vamos a definir tu nivel de dificultad: \n", nombre);
		System.out.println("1- Elegir mi nivel");
		System.out.println("2- Evaluar mi conocimiento actual");
		int opcion = read.nextInt();
		int nivel = 1;
		switch (opcion) {
		case 1:
			System.out.print("Elija una de las opciones: \n 1- Básico \n 2- Intermedio \n 3- Avanzado \n");
			nivel = read.nextInt();
			break;
		// Puse 1 como ejemplo pero acá iría el método que nos permita evaluar el
		// conocimiento y retorne el nivel
		case 2:
			nivel = 1;
		}

		User usuario = new User(nombre, nivel);
		String nivelStr = usuario.nivelUsuarioAString();
		
		// MENÚ ACTIVIDADES
		System.out.println("¿Qué te gustaría hacer?");
		System.out.print("1- Estudiar un concepto específico \n2- Estudiar temas aleatorios \n3- Subir de nivel de "
				+ "dificultad\n");
		int actividad = read.nextInt();
		switch (actividad) {
		case 1:
			catalogo.mostrarCapitulosPorNivel(nivelStr);
			// Desplegar catálogo por dificultad, seleccionar uno y guardarlo en una
			// variable "concepto"
			// mostrarTeoriaPorConcepto(nivel, concepto)
			Teoria mensajeTeoria = new Teoria();
			System.out.println(mensajeTeoria);
			break;
		case 2:
			// mostrarTeoriaAleatoriamente(nivel)
			break;
		case 3:
			// tomarTestDeNivel()
			// Setear nuevo nivel o mantener el anterior
			break;
		}

		read.close();
	}

}