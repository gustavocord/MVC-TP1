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




public class Tabla extends JFrame  implements ActionListener {

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
		
		// recorre los botones y los dibuja
		for(int i = 0; i < tablero.getBotones().length ; i++) {
			for(int j = 0; j < tablero.getBotones()[i].length; j++) {
				// crea el boton y luego dependiendo el estado le pone el color de fondo
				
				
				JButton botn = new JButton("");
				botones[i][j]=botn;
				if(tablero.getBotones()[i][j].getEstado()) {
					botn.setBorderPainted(false);
					botn.setBackground(Color.black);
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
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//if(event.getSource()==botn) {
			//System.out.println("se presiono");
			boolean presionado = false;
			
			int i = 0, j = 0;
	        while (i < botones.length && !presionado) {
	 
	        	if (((JButton) event.getSource()).equals(botones[i][j])) {
	        		presionado= true;
	        		System.out.println("se presiono");
	        	}
	            
	            if (j == botones[0].length - 1) {
	                i++;
	                j = 0;
	            } else {
	                j++;
	            }
	 
	        }
	        
	        tablero.cambiarEstado(i, j);
	        
	        
	        
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
	
	/*
	 * realizar funcionalidad de botones con matriz
*/
	
		



