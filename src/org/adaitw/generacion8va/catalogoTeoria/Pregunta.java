package org.adaitw.generacion8va.catalogoTeoria;

import java.util.Arrays;

public class Pregunta {
	private int nroCapitulo;
	private int nroConcepto;
	private int nroPregunta;
	private String pregunta;
	private String[] respuestas;
	private int respuestaCorrecta;
	
	public Pregunta(int nroCapitulo, int nroConcepto, int nroPregunta, String pregunta, String[] respuestas,
			int respuestaCorrecta) {
		super();
		this.nroCapitulo = nroCapitulo;
		this.nroConcepto = nroConcepto;
		this.nroPregunta = nroPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public int getNroConcepto() {
		return nroConcepto;
	}

	public int getNroPregunta() {
		return nroPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public String[] getRespuestas() {
		return respuestas;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Pregunta " + nroPregunta + ": " + pregunta + "\n"
				+ Arrays.toString(respuestas) + "\nRespuestaCorrecta=" + respuestaCorrecta;
	}
	
	
	
}
