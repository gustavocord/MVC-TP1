package view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.StyleConstants.ColorConstants;

import controller.Tablero;
import controller.Boton;


import java.awt.Color;




public class Tabla extends JFrame   {

	JFrame frame;
	private Tablero tablero;
	JButton [][]botones; //va a estar ubicado igual que el que viene en la logica
	
	
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
		this.botones=new JButton[4][4];
	
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
		frame.setTitle("JUEGO DE LUCES"); //para que aparezca el nombre del juego en pantalla
		
		try {   //cambio de estilo, en las ventanas
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			((Throwable) e).printStackTrace();
		}
		
		// recorre los botones y los dibuja
		for(int i = 0; i < tablero.getBotones().length ; i++) {
			for(int j = 0; j < tablero.getBotones()[i].length; j++) {
				// crea el boton y luego dependiendo el estado le pone el color de fondo
				
				
				JButton botn = new JButton("");
				botones[i][j]=botn;
				if(tablero.getBotones()[i][j].getEstado()) {
					botn.setBorderPainted(false);
					botn.setBackground(Color.black);
					botn.setEnabled(true); 
					botn.addActionListener(new ButtonPress());
				}
				else {
					botn.setBorderPainted(false);
					botn.setBackground(Color.green);
					botn.addActionListener(new ButtonPress());
				}
				
				frame.getContentPane().add(botn);
			}
		}	
		
	}

	
	private class ButtonPress implements ActionListener {	
	

	
	public void actionPerformed(ActionEvent e) {

		
		//if(event.getSource()==botn) {
			//System.out.println("se presiono");
			boolean presionado = false;
			
			for (int i = 0; i < botones.length; i++) {
				for (int j = 0; j < botones[i].length; j++) {
					if (((JButton) e.getSource()).equals(botones[i][j])) {
						  tablero.cambiarEstadoVecinos(i, j);
					        System.out.println("i : "+ i+" j: "+j);
					  
					        actualizarBotones();
						    presionado = true;

					}
				}
				
	        
	      
			}
	        
	        
		}
	}
	

	
	
	//actualizar botones
	
	public void actualizarBotones() {
		for(int i = 0; i < botones.length ; i++) {
			for(int j = 0; j < botones[i].length; j++) {
		
				if(tablero.getBotones()[i][j].getEstado()) {
					 botones[i][j].setBackground(Color.black);
				
				}
				else {
				
					 botones[i][j].setBackground(Color.green);
					
				}
	}
	
	


	}
}
	}




	
	/*
	 * realizar funcionalidad de botones con matriz
*/
	
		



