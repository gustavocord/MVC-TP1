package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JPanelResultado extends JPanel {

	/**
	 * Create the panel.
	 */
	private JLabel lblJugador;
	//private String resultado = "Ganaste Felicidades";
	
	public JPanelResultado() {

		try {   //cambio de estilo, en las ventanas
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			((Throwable) e).printStackTrace();
		}
		
		this.setBounds(0, 0, 521, 325);
		setLayout(null);
		
		lblJugador = new JLabel();
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblJugador.setBounds(152, 38, 234, 49);
		add(lblJugador);
		
		
		
	
	
	}
	
	
	public void setResultado(boolean resultado) {
		if (resultado) {
			this.lblJugador.setText("Felicidades ganaste");
		}
		else {
			this.lblJugador.setText("Perdedor");

		}
	}
	
	
}
