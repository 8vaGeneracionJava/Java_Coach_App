package org.adaitw.generacion8va.application;

import org.adaitw.generacion8va.catalogoTeoria.Capitulo;
import org.adaitw.generacion8va.lectores.LectorCatalogo;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        // MENÚ INICIAL
        //Acá iría un método que muestre el mensaje de bienvenida
        System.out.print("Bienvenido/a a Java Coach App! \nA continuación ingrese su nombre: \n");
        String nombre = read.nextLine();
        System.out.printf("Hola %s! \nAhora vamos a definir tu nivel de dificultad: \n", nombre);
        System.out.println("1- Elegir mi nivel");
        System.out.println("2- Evaluar mi conocimiento actual");
        int opcion = read.nextInt();
        int nivel = 1;
        switch (opcion){
            case 1:
                System.out.print("Elija una de las opciones: \n 1- Básico \n 2- Intermedio \n 3- Avanzado \n");
                nivel = read.nextInt();
                break;
                //Puse 1 como ejemplo pero acá iría el método que nos permita evaluar el conocimiento y retorne el nivel
            case 2: nivel = 1;
        }

         User usuario = new User(nombre, nivel);

        //MENÚ ACTIVIDADES
        System.out.println("¿Qué te gustaría hacer?");
        System.out.print("1- Estudiar un concepto específico \n2- Estudiar temas aleatorios \n3- Subir de nivel de " +
                "dificultad\n");
        int actividad = read.nextInt();
        switch (actividad){
            case 1:
                mostrarCatalogoPorNivel(usuario);
                //Falta mostrar conceptos para poder seleccionar nro de capitulo y nro de concepto
                // mostrarTeoriaPorConcepto(Concepto concepto)
                break;
            case 2:
                // mostrarTeoriaAleatoriamente(nivel)
                break;
            case 3:
                //tomarTestDeNivel()
                //Setear nuevo nivel o mantener el anterior
                break;
        }

    }

    public static void mostrarCatalogoPorNivel(User usuario) throws FileNotFoundException {
        LinkedList<Capitulo> catalogo = LectorCatalogo.leerCapitulos();
        for (Capitulo capitulo : catalogo) {
            if((usuario.getNivel() == 1 && capitulo.getDificultad().equals("Basico")) || (usuario.getNivel() == 2 && capitulo.getDificultad().equals("Intermedio")) || (usuario.getNivel() == 3 && capitulo.getDificultad().equals("Avanzado"))){
                System.out.println(capitulo);
            }
        }

    }
}
