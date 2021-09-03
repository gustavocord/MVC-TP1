package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JPanelResultado extends JPanel {

	/**
	 * Create the panel.
	 */
	private JLabel lblGanador;
	
	public JPanelResultado() {

		this.setBounds(0, 0, 521, 325);
		setLayout(null);
		
		lblGanador = new JLabel("Ganaste Felicidades");
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblGanador.setBounds(152, 38, 234, 49);
		add(lblGanador);
		
		
		
		
		
	
	
	}
}
