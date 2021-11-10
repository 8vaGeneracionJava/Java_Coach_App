package org.adaitw.generacion8va.application.mensaje.teoria;

import org.adaitw.generacion8va.application.mensaje.Mensaje;

public class Teoria extends Mensaje{
    private String titulo1;
    private String teoria1;

    @Override
    public void armarTituloMensaje(int nroConcepto){
        titulo = listaConceptos.get(nroConcepto).nombre;
    }

    @Override
    public void armarCuerpoMensaje(int nroConcepto) {
        teoria = listaConceptos.get(nroConcepto).teoria;
    }

    public Teoria(int nroConcepto){
        armarTituloMensaje(nroConcepto);
        armarCuerpoMensaje(nroConcepto);
    }

    public Teoria(){
        int nroConcepto = Math.random()*10;
        armarTituloMensaje(nroConcepto);
        armarCuerpoMensaje(nroConcepto);
    }

    @Override
    public String toString() {
        return (titulo1 + ": \n" + teoria1);
    }


}
