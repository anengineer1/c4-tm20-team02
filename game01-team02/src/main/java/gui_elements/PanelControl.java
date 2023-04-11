
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
package gui_elements;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controller.PanelController;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;

public class PanelControl extends JPanel {
	public JButton btnNewButton;
	public JTextField textField, textField_1, NombreJugador1, NombreJugador2;
	public ButtonGroup group1, group2;
	public JRadioButton boton1Humano, boton2Humano, boton1CPU, boton2CPU;
	public String group1Selected, group2Selected;
	public JTextPane textPane;
	public JLabel jugadorColocaFicha;

	public PanelControl(PanelController pc) {
		setBackground(new Color(74, 70, 70));
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 587, 529);
		this.setLayout(null);

		// NUEVA PARTIDA
		btnNewButton = new JButton("Nueva Partida");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Liberation Mono", Font.BOLD, 16));
		btnNewButton.setActionCommand("NUEVA PARTIDA");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 204, 0), null, null, null));
		btnNewButton.setBounds(207, 11, 158, 44);
		this.add(btnNewButton);

		JPanel subPanel1 = new JPanel();
		subPanel1.setBackground(Color.LIGHT_GRAY);
		subPanel1.setBorder(new LineBorder(new Color(255, 255, 255), 7, true));
		subPanel1.setBounds(140, 118, 287, 122);
		add(subPanel1);
		subPanel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Jugador 1");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Liberation Mono", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 15, 198, 20);
		subPanel1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(56, 46, 60, 14);
		subPanel1.add(lblNewLabel_1);

		// Recuadro de texto para el nombre de jugador 1
		NombreJugador1 = new JTextField();
		NombreJugador1.setBounds(138, 45, 115, 20);
		NombreJugador1.setColumns(10);
		subPanel1.add(NombreJugador1);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(56, 82, 43, 17);
		subPanel1.add(lblNewLabel_1_1);

		// Botones tipo radio correspondientes a jugador 1
		boton1Humano = new JRadioButton("Humano");
		boton1Humano.setBackground(Color.LIGHT_GRAY);
		boton1Humano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		boton1Humano.setBounds(124, 80, 76, 23);
		subPanel1.add(boton1Humano);

		boton1CPU = new JRadioButton("CPU");
		boton1CPU.setBackground(Color.LIGHT_GRAY);
		boton1CPU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		boton1CPU.setBounds(202, 80, 60, 23);
		subPanel1.add(boton1CPU);

		// Group the radio buttons.
		group1 = new ButtonGroup();
		group1.add(boton1Humano);
		group1.add(boton1CPU);

		JPanel subPanel2 = new JPanel();
		subPanel2.setBackground(Color.LIGHT_GRAY);
		subPanel2.setBorder(new LineBorder(Color.WHITE, 5, true));
		subPanel2.setBounds(140, 258, 287, 110);
		add(subPanel2);
		subPanel2.setLayout(null);

		JLabel lblJugador = new JLabel("Jugador 2");
		lblJugador.setForeground(Color.DARK_GRAY);
		lblJugador.setFont(new Font("Liberation Mono", Font.BOLD, 16));
		lblJugador.setBounds(29, 11, 230, 31);
		subPanel2.add(lblJugador);

		JLabel lblNewLabel_1_2 = new JLabel("Nombre");
		lblNewLabel_1_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(55, 43, 67, 14);
		subPanel2.add(lblNewLabel_1_2);

		// Recuadro de texto para el nombre de jugador 2
		NombreJugador2 = new JTextField();
		NombreJugador2.setBounds(144, 42, 115, 20);
		NombreJugador2.setColumns(10);
		subPanel2.add(NombreJugador2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(55, 68, 40, 23);
		subPanel2.add(lblNewLabel_1_1_1);

		// Botones tipo radio correspondientes a jugador 2
		boton2Humano = new JRadioButton("Humano");
		boton2Humano.setBackground(Color.LIGHT_GRAY);
		boton2Humano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		boton2Humano.setBounds(131, 69, 77, 23);
		subPanel2.add(boton2Humano);

		boton2CPU = new JRadioButton("CPU");
		boton2CPU.setBackground(Color.LIGHT_GRAY);
		boton2CPU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		boton2CPU.setBounds(210, 69, 60, 23);
		subPanel2.add(boton2CPU);

		// Group the radio buttons.
		group2 = new ButtonGroup();
		group2.add(boton2Humano);
		group2.add(boton2CPU);

		//TODO mostrar nombre jugador al que le toca colocar ficha
		jugadorColocaFicha = new JLabel("Jugador :  coloca ficha");
		jugadorColocaFicha.setIcon(new ImageIcon(PanelControl.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-more-details.png")));
		jugadorColocaFicha.setBackground(Color.ORANGE);
		jugadorColocaFicha.setForeground(new Color(255, 204, 102));
		jugadorColocaFicha.setHorizontalAlignment(SwingConstants.LEFT);
		jugadorColocaFicha.setFont(new Font("Liberation Mono", Font.BOLD, 14));
		jugadorColocaFicha.setBounds(111, 82, 287, 25);
		add(jugadorColocaFicha);

		//TODO Este recuadro lo utilizaremos para mostrar mensajes o el resultado de la partida
		textPane = new JTextPane();
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 204, 102), null, null, null));
		textPane.setBounds(43, 408, 477, 110);
		add(textPane);

		JLabel lblNewLabel_2 = new JLabel("Resultado / mensajes");
		lblNewLabel_2.setIcon(new ImageIcon(PanelControl.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		lblNewLabel_2.setForeground(new Color(255, 204, 102));
		lblNewLabel_2.setFont(new Font("Liberation Mono", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(111, 365, 287, 61);
		add(lblNewLabel_2);


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
