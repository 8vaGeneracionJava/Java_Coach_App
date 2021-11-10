package org.adaitw.generacion8va.application;

import org.adaitw.generacion8va.catalogoTeoria.Capitulo;
import org.adaitw.generacion8va.catalogoTeoria.Concepto;
import org.adaitw.generacion8va.catalogoTeoria.Pregunta;
import org.adaitw.generacion8va.lectores.LectorCatalogo;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
	
	static LinkedList<Capitulo> catalogo;
    
	public static void main(String[] args) throws FileNotFoundException {
		LectorCatalogo lector = new LectorCatalogo();
		catalogo = lector.getCapitulos();
    			
        Scanner read = new Scanner(System.in);
        // MENÚ INICIAL
        //Acá irá un método que muestre el mensaje de bienvenida
        System.out.print("Bienvenido/a a Java Coach App! \nA continuación ingrese su nombre: \n");
        String nombre = read.nextLine();
        System.out.println();
        System.out.printf("Hola %s! \nAhora vamos a definir tu nivel de dificultad: \n", nombre);
        System.out.println("1- Elegir mi nivel");
        System.out.println("2- Evaluar mi conocimiento actual");
        int opcion = read.nextInt();
        System.out.println();
        int nivel = 1;
        switch (opcion){
            case 1:
                System.out.print("Elija una de las opciones: \n 1- BÃ¡sico \n 2- Intermedio \n 3- Avanzado \n");
                nivel = read.nextInt();
                break;
                //Puse 1 como ejemplo pero acá irá el método que nos permita evaluar el conocimiento y retorne el nivel
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
        read.close();
    }

    public static void mostrarCatalogoPorNivel(User usuario){
        for (Capitulo capitulo : catalogo) {
            if((usuario.getNivel() == 1 && capitulo.getDificultad().equals("Basico")) || (usuario.getNivel() == 2 && capitulo.getDificultad().equals("Intermedio")) || (usuario.getNivel() == 3 && capitulo.getDificultad().equals("Avanzado"))){
                mostrarConceptosDeUnCapitulo(capitulo.getNroCapitulo());;
            }
        }
    }
    
    public static void mostrarConceptosDeUnCapitulo(int nroCapitulo) {
    	for (Capitulo cap : catalogo) {
    		if (cap.getNroCapitulo() == nroCapitulo) {
    			System.out.println(cap);
    			for(Concepto concep : cap.getConceptos()) {
    				System.out.println(concep);
    			}
    			break;
    		}
    	}
    }
    
    public static void mostrarPregunta(int nroCapitulo, int nroConcepto, int nroPregunta) {
    	for (Capitulo cap : catalogo) {
    		if (cap.getNroCapitulo() == nroCapitulo) {
    			System.out.println(cap);
    			for(Concepto concep : cap.getConceptos()) {
    				if (concep.getNroConcepto() == nroConcepto) {
    					System.out.println(concep.getNombre());
    					for(Pregunta preg : concep.getPreguntas()) {
    						if(preg.getNroPregunta() == nroPregunta) {
    							System.out.println(preg);
    						}
    					}
    						
    				}
    			}
    		}
    	}
    }
    
    public static void  buscarYMostrarConcepto(String busqueda) {
    	String str = busqueda.toLowerCase();
    	
    	for (Capitulo cap : catalogo) {
    		LinkedList<Concepto> conceptos = cap.getConceptos();
    		for(Concepto concep : conceptos) {
    			String nombre = concep.getNombre();
    			if (nombre.equalsIgnoreCase(str)) {
    				System.out.println(nombre + ": " + concep.getTeoria());
    			}
    		}
    	}
    }
    
    
}
