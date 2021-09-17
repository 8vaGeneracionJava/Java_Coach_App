package org.adaitw.generacion8va.application;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        User user = new User();
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienveni@");
        System.out.println("Introduzca su nombre de usuario: ");
        user.setName(scan.nextLine());
        System.out.println("Introduzca su contraseña: ");
        user.setPassword(scan.nextLine());
        System.out.printf("Los datos del usuario son: %s", user.showUser());
    }
}
