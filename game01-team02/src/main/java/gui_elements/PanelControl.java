
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
package gui_elements;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PanelControl extends JPanel{

	private JTextField NombreJugador1;
	private JTextField NombreJugador2;

	public PanelControl() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 488, 393);
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Nueva Partida");
		btnNewButton.setBounds(169, 11, 120, 28);
		this.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Jugador 1");
		lblNewLabel.setBounds(24, 47, 60, 28);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(24, 86, 60, 22);
		this.add(lblNewLabel_1);
		
		NombreJugador1 = new JTextField();
		NombreJugador1.setBounds(94, 86, 106, 22);
		this.add(NombreJugador1);
		NombreJugador1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setBounds(24, 133, 60, 22);
		this.add(lblNewLabel_1_1);
		
		JRadioButton boton1Humano = new JRadioButton("Humano");
		boton1Humano.setBounds(94, 133, 65, 23);
		this.add(boton1Humano);
		
		JRadioButton boton1CPU = new JRadioButton("CPU");
		boton1CPU.setBounds(172, 133, 53, 23);
		this.add(boton1CPU);
		
		JLabel lblJugador = new JLabel("Jugador 2");
		lblJugador.setBounds(24, 188, 60, 28);
		this.add(lblJugador);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre");
		lblNewLabel_1_2.setBounds(24, 227, 60, 22);
		this.add(lblNewLabel_1_2);
		
		NombreJugador2 = new JTextField();
		NombreJugador2.setColumns(10);
		NombreJugador2.setBounds(94, 227, 106, 22);
		this.add(NombreJugador2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1_1.setBounds(24, 274, 60, 22);
		this.add(lblNewLabel_1_1_1);
		
		JRadioButton boton2Humano = new JRadioButton("Humano");
		boton2Humano.setBounds(94, 274, 65, 23);
		this.add(boton2Humano);
		
		JRadioButton boton2CPU = new JRadioButton("CPU");
		boton2CPU.setBounds(172, 274, 53, 23);
		this.add(boton2CPU);
	}
}
