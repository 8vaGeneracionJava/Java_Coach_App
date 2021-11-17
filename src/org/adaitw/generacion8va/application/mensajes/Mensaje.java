package org.adaitw.generacion8va.application.mensajes;

/* MOSTRAR CONTENIDO --> CONCEPTOS
* CAPITULO 1        -->
*   CONCEPTO 1
*   CONCEPTO 2
*   CONCEPTO 3
*
* CAPITULO 2
* .
* .
* .
* CAPITULO 6
* 
* */
/* 
 * Mensaje de Bienvenida: deberá recibir el usuario y saludarlo por su nombre. Si no hay usuario preguntar el nombre. (Pospuesto)
    * Mensaje de Menú: deberá mostrar las opciones del usuario. (Pospuesto)
    * Mensaje de Pregunta: deberá recibir una pregunta y detectar después mostrarlo si la respuesta introducida es correcta.
    * Mensaje de Teoría: deberá recibir un concepto teórico y mostrarlo.
    * Mensaje de Ejemplo: deberá recibir un ejemplo de un concepto y mostrarlo.
 */

public abstract class Mensaje {
	private String titulo;
	private String teoria;

	public Mensaje() {
    	
    }

	public abstract void armarTituloMensaje();


	public abstract void armarCuerpoMensaje();
}
