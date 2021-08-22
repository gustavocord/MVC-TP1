package view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.text.StyleConstants.ColorConstants;

import controller.Tablero;
import controller.Boton;


import java.awt.Color;




public class Tabla extends JFrame {

	JFrame frame;
	private Tablero tablero;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) 
		{}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla window = new Tabla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Tabla() {
		super(" juego de luces");
		this.tablero = new Tablero(4,4);
	
		initialize();
	}

	/**
	 * inicializa el contenido del frame
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 8, 8));
		
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// recorre los botones y los dibuja
		for(int i = 0; i < tablero.getBotones().length ; i++) {
			for(int j = 0; j < tablero.getBotones()[i].length; j++) {
				// crea el boton y luego dependiendo el estado le pone el color de fondo
				
				JButton botn = new JButton("");
				if(tablero.getBotones()[i][j].estado()) {
					botn.setBorderPainted(false);
					botn.setBackground(Color.black);
				}
				else {
					botn.setBorderPainted(false);
					botn.setBackground(Color.green);
				}
				
				frame.getContentPane().add(botn);
			}
		}
		
		
		
		
		
	}
	
	// hay que implementar bien esto
	/*
	private class ButtonPress implements ActionListener {
		
	
		@Override
		public void actionPerformed(ActionEvent action) {
		
			boolean done = false;
			int x = 0;
			int y = 0;
			for (int i = 0; i < tablero.getBotones().length; i++) {
				for (int j = 0; j < tablero.getBotones()[i].length; j++) {
					if (((JButton) action.getSource()).equals(tablero.getBotones()[i][j])) {
						done = true;
						x = i;
						y = j;
						break;
					}
				}
				if (done) {
					break;
				}
			}
			cambiarColor(tablero.getBotones()[x][y]);//cambia el color donde se hizo click
			if (x > 0) {// Check if there is a space available to the left of the selected tile
				cambiarColor(tablero.getBotones()[x - 1][y]);
			}
			if (x < tablero.getBotones().length - 1) {// Check if there is a space available to the right of the selected tile
				cambiarColor(tablero.getBotones()[x + 1][y]);
			}
			if (y > 0) {// Check if there is a space available to the top of the selected tile
				cambiarColor(tablero.getBotones()[x][y - 1]);
			}
			if (y < tablero.getBotones()[x].length - 1) {// Check if there is a space available to the bottom of the selected tile
				cambiarColor(tablero.getBotones()[x][y + 1]);
			}
			
		}
		

		public void cambiarColor(Boton boton) {//cambiamos el estado depende el color
			
			if (boton.estado()) {
				
				boton.cambiarEstado(false);;
			} else {
				boton.cambiarEstado(true);
			}
		}
} */
}

