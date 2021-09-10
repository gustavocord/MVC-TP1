package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Tablero;

public class JPanelTabla extends JPanel {

	/**
	 * Create the panel.
	 */

	private Tablero tablero;
	private JButton[][] botones; //va a estar ubicado igual que el que viene en la logica

	public JPanelTabla() {
		this.setBounds(0, 0, 521, 325);
		
		this.tablero = new Tablero(4,4)
				;
		this.botones=new JButton[4][4];
		
		this.setBackground(Color.white);

		this.setLayout(new GridLayout(4, 4, 8, 8));

		
		

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

				this.add(botn);
			}
		}	
	}


	
	//  la clase ButtonPress implementa ActionListener
	
	private class ButtonPress implements ActionListener {	
		
		// recorre y  verifica si se presiono un boton
		public void actionPerformed(ActionEvent e) {	
			for (int i = 0; i < botones.length; i++) {
				for (int j = 0; j < botones[i].length; j++) {
					if (((JButton) e.getSource()).equals(botones[i][j])) {
						tablero.cambiarEstados(i, j);
						hayGanador();
						actualizarBotones();
						UIMain.actualizarMain();

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
	
	
	
	
	public void hayGanador() {
		
		if(tablero.gano()) {
			UIMain.cambiarAPanelResultado(true);
		}
		
		if(tablero.getMovimiento()>=20) {
			UIMain.cambiarAPanelResultado(false);
		}
		
		
	}
	
	
}




