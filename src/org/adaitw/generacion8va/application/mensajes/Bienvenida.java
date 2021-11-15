package org.adaitw.generacion8va.application.mensajes;

import java.util.Scanner;

public class Bienvenida {

    public void mensajeBienvenida(){
        System.out.println("Bienvenido a Java Coach app, acá te ayudaremos a certificarte en Oracle como" +
                " programador/a de Java SE 8.");
    }

    public String nombreUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa tu nombre de usuario: ");
        String user = scanner.next();
        scanner.close();
        return user;
    }

    public Bienvenida(){};


}
