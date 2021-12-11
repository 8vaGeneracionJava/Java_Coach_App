package org.adaitw.generacion8va.application;

import java.util.Scanner;

public class User {
    private String nombre;
    private int nivel;
    private String mail;

    public User(String nombre, int nivel, String mail) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.mail = mail;
    }
    // Metodo de alerta (cuando pasa mucho tiempo sin estudiar)
    public void notificacion(){
    }

    public void intervaloAlerta(){
    }

    // Metodo para notificar al usuario
    // Metodo para seleccionar tiempo de estudio
    // Metodo de seleccion de forma de recibir la alerta
    // Metodo de evaluacion al final de cada capitulo
    public int evaluarCadaCapitulo(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Desea evaluar su conocimiento al final de cada capitulo? \n 1- Si \n 2-No");
        int opcionEvaluacionCapt = lector.nextInt();
        return opcionEvaluacionCapt;
    }

    // Metodo de autoevaluacion de forma aleatoria

    public String nivelUsuarioAString() {
		switch (nivel) {
		case 1:
			return "Basico";
		case 2:
			return "Intermedio";
		case 3:
			return "Avanzado";
		}
		return "Basico";
	}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
