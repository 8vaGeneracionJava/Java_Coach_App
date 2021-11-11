package org.adaitw.generacion8va.application;

public class User {
    private String nombre;
    private int nivel;

    public User(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

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
}
