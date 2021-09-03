package controller;

import java.util.Random;

public class Tablero {
	
	private Boton[][] botones;

	
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
	
	// si estan todos en true gano
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
	public void cambiarEstado(int i , int j) {
		System.out.println("ahora "+  botones[i][j].getEstado());

		if (botones[i][j].getEstado()) {
			botones[i][j].setEstado(false);
		}
		else {
			botones[i][j].setEstado(true);		}
		
		System.out.println("despues "+  botones[i][j].getEstado());
	}
	
	

// cambia el estado de los vecinos dependiendo la ubicacion del boton apretado	No funciona bien
	public void cambiarEstadoVecinos(int i, int j) {
		cambiarEstado(i,j);
		if(i>0) {
			cambiarEstado(i-1,j);
		}
		if(i<botones.length-1) {
			cambiarEstado(i+1,j);
		
		}
		
		if(j>0) {
			cambiarEstado(i,j-1);
		}
		if(j<botones.length-1) {
			cambiarEstado(i,j+1);
		}
		//sumarPuntaje();
	
		 
	
	}

	
	
	
}