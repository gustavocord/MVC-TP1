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
	private JLabel lblGanador;
	private String resultado = "Ganaste Felicidades";
	
	public JPanelResultado() {

		try {   //cambio de estilo, en las ventanas
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			((Throwable) e).printStackTrace();
		}
		
		this.setBounds(0, 0, 521, 325);
		setLayout(null);
		
		lblGanador = new JLabel();
		lblGanador.setText(resultado);
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblGanador.setBounds(152, 38, 234, 49);
		add(lblGanador);
		
		
		
		
		
	
	
	}
}
