package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import controller.Tablero;


public class UIMain {
	private JFrame frame;
	private static JLayeredPane layeredPane;
	private static JPanelTabla tabla;
	private static JPanelResultado resultado;
	private static JLabel movimientos;
	private static JLabel puntaje;
	private Fondo fondo;
	
	
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
		this.fondo= new Fondo("/imagenes/fondo.jpg");
		frame.setContentPane(fondo);
		
		frame.setBounds(100, 100, 537, 364);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Ligth out");

		
		
		this.movimientos=new JLabel();
		movimientos.setBounds(150, 230, 537, 364);
		frame.add(movimientos);
		movimientos.setText("Movimientos : "+ Tablero.getMovimiento());
		movimientos.setFont( new Font("Serif", Font.BOLD, 20));
		
		this.puntaje=new JLabel();
		puntaje.setBounds(350, 230, 537, 364);
		frame.add(puntaje);
		puntaje.setText("Puntaje : "+ Tablero.getPuntaje());
		puntaje.setFont( new Font("Serif", Font.BOLD, 20));
	

		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(125, 50, 521, 325);
		frame.getContentPane().add(layeredPane);
		
		
		tabla = new JPanelTabla();
		tabla.setVisible(true);
		layeredPane.add(tabla);
		
		
		resultado = new JPanelResultado();
		resultado.setVisible(false);
		layeredPane.add(resultado);
		
		
	}
	
	
	protected static void cambiarAPanelResultado(boolean result){
		
			tabla.setVisible(false);
			resultado.setResultado(result);
			resultado.setVisible(true);
			movimientos.setVisible(false);
			
		
	}
	
	protected static void actualizarMain(){
		movimientos.setText("Movimientos : "+ Tablero.getMovimiento());
		puntaje.setText("Puntaje : "+ Tablero.getPuntaje());


}
	
}