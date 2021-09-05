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
	

	
	public JPanelResultado () {

		try {   //cambio de estilo, en las ventanas
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			((Throwable) e).printStackTrace();
		}
		
		
		this.setBounds(0, 0, 521, 325);		
		lblJugador = new JLabel();
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblJugador.setBounds(152, 38, 234, 49);
		add(lblJugador);
		
	
	}
	
	// le falta "estilo" , no pude ponerle un fondo
	public void setResultado(boolean resultado) {
		if (resultado) {
			this.lblJugador.setText("Felicidades ganaste");
		}
		else {
			this.lblJugador.setText("upps se le terminaron los movimientos");

		}
	}
	
	
}
