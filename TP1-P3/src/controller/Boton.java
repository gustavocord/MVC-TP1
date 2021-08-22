package controller;

public class Boton {
	
private boolean estado;
	
	public Boton(boolean estado) {
		this.estado = estado;
	}
	
	public void cambiarEstado(boolean estado) {
		if (estado) {
			estado=false;
		}
		else {
			estado = true;
		}
	}

	public boolean estado() {
		return estado;
	}

	
	
	
	


}
