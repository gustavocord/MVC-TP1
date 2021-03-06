package controller;

import java.util.Random;

public class Tablero {
	
	private Boton[][] botones;
	private static int  movimientos=0;
	private static int puntaje = 200;

	
	// genera los botones con booleanos aleatorios
	public Tablero(int filas, int columnas) {
		this.botones = new Boton[filas][columnas];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				Random random = new Random();
				boolean valor = random.nextBoolean();
				this.botones[i][j] = new Boton(valor);
			}
		}
	}
	

	public Boton[][] getBotones() {
		return botones;
	}

	
	public void setTablero(Boton[][] tablero) {
		this.botones = tablero;
	}
	
	
	public boolean gano() {
		
		boolean win = true;
		for (int i= 0 ; i<this.botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				win = this.botones[i][j].getEstado() && win;
			}
		}
		return win;
		
	}
	
	
	// cambiamos el estado del boton
	public void cambiarEstadoBoton(int i , int j) {

		if (botones[i][j].getEstado()) {
			botones[i][j].setEstado(false);
		}
		else {
			botones[i][j].setEstado(true);		}
		
	}
	
	

// cambia el estado de los vecinos dependiendo la ubicacion del boton apretado	No funciona bien
	public void cambiarEstadoVecinos(int i, int j) {
		
		if(i>0) {
			cambiarEstadoBoton(i-1,j);
		}
		if(i<botones.length-1) {
			cambiarEstadoBoton(i+1,j);
		
		}
		
		if(j>0) {
			cambiarEstadoBoton(i,j-1);
		}
		if(j<botones.length-1) {
			cambiarEstadoBoton(i,j+1);
		}
	}
	
	
	
	public  void actualizarMovimiento() {
		movimientos++;
	}
	
	
	public void cambiarEstados(int i, int j) {
		cambiarEstadoVecinos(i,j);
		cambiarEstadoBoton(i,j);
		actualizarMovimiento();
		actualizarPuntaje();
		
	}
	
	

	public static  int getMovimiento() {
		return movimientos;
	}
	
	
	public static void actualizarPuntaje() {
		
		puntaje = puntaje-10;
	}
	
	
	public static  int getPuntaje() {
		return puntaje;
	}
	
	
	
	
	
}