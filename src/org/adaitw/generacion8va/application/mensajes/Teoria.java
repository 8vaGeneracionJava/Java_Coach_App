package org.adaitw.generacion8va.application.mensajes;

public class Teoria extends Mensaje{
    private String titulo1;
    private String teoria1;

//    No hay metodos que se sobreescriban, el original no tiene parametros
    
//    @Override
//    public void armarTituloMensaje(int nroConcepto){
//        titulo = listaConceptos.get(nroConcepto).nombre;
//    }
//
//    @Override
//    public void armarCuerpoMensaje(int nroConcepto) {
//        teoria = listaConceptos.get(nroConcepto).teoria;
//    }

//    public Teoria(int nroConcepto){
//        armarTituloMensaje(nroConcepto);
//        armarCuerpoMensaje(nroConcepto);
//    }
//
//    public Teoria(){
//        int nroConcepto = (int) Math.random()*10;
//        armarTituloMensaje(nroConcepto);
//        armarCuerpoMensaje(nroConcepto);
//    }

    @Override
    public String toString() {
        return (titulo1 + ": \n" + teoria1);
    }

	@Override
	public void armarTituloMensaje() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armarCuerpoMensaje() {
		// TODO Auto-generated method stub
		
	}


}
