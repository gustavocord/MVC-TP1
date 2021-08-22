package controller;

import java.util.Random;

public class Tablero {
	
	private Boton[][] botones;
	private int  cantidadJugada = 0; 
	
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
				win = this.botones[i][j].estado() && win;
			}
		}
		return win;
	}
	
	
}