package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UIMain {
	private JFrame frame;
	private static JLayeredPane layeredPane;
	private static JPanelTabla tabla;
	private static JPanelResultado resultado;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain window = new UIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UIMain() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 364);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Juego de Luces");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 521, 325);
		frame.getContentPane().add(layeredPane);
		
		
		tabla = new JPanelTabla();
		tabla.setVisible(true);
		layeredPane.add(tabla);
		
		
		resultado = new JPanelResultado();
		resultado.setVisible(false);
		layeredPane.add(resultado);
		
		
	}
	
	
	protected static void cambiarAPanelResultado(){
		
			tabla.setVisible(false);
			resultado.setVisible(true);
		
	}
	
}