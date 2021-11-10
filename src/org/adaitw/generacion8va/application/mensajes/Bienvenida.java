package org.adaitw.generacion8va.application.mensajes;

import java.util.Scanner;

public class Bienvenida {

    public void mensajeBienvenida(){
        System.out.println("Bienvenido a Java Coach app, este es un bot que te ayudará a certificarte en Oracle como" +
                " programador/a de Java SE 8.");
    }

    public String nombreUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("A continuacion ingrese su nombre: ");
        String user = scanner.next();
        scanner.close();
        return user;
    }

    public Bienvenida(){};


}
