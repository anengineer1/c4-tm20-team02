
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
package gui_elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.PanelController;

import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class PanelControl extends JPanel{
	private JTextField textField;
	private JTextField textField_1;

	public PanelControl() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 488, 490);
		this.setLayout(null);
		PanelController pc = new PanelController();
		
		// NUEVA PARTIDA
		JButton btnNewButton = new JButton("Nueva Partida");
		btnNewButton.setBounds(169, 11, 120, 28);
		this.add(btnNewButton);
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		subPanel1.setBounds(120, 97, 250, 128);
		add(subPanel1);
		subPanel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jugador 1");
		lblNewLabel.setBounds(11, 9, 48, 14);
		subPanel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(11, 37, 48, 14);
		subPanel1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(94, 34, 115, 20);
		textField.setColumns(10);
		subPanel1.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setBounds(10, 94, 43, 17);
		subPanel1.add(lblNewLabel_1_1);
		
		JRadioButton boton1Humano = new JRadioButton("Humano");
		boton1Humano.setBounds(70, 91, 65, 23);
		subPanel1.add(boton1Humano);
		
		JRadioButton boton1CPU = new JRadioButton("CPU");
		boton1CPU.setBounds(153, 91, 45, 23);
		subPanel1.add(boton1CPU);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		subPanel2.setBounds(120, 262, 250, 128);
		add(subPanel2);
		subPanel2.setLayout(null);
		
		JLabel lblJugador = new JLabel("Jugador 2");
		lblJugador.setBounds(10, 8, 48, 14);
		subPanel2.add(lblJugador);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre");
		lblNewLabel_1_2.setBounds(10, 36, 48, 14);
		subPanel2.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 30, 115, 20);
		textField_1.setColumns(10);
		subPanel2.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1_1.setBounds(10, 90, 40, 14);
		subPanel2.add(lblNewLabel_1_1_1);
		
		JRadioButton boton2Humano = new JRadioButton("Humano");
		boton2Humano.setBounds(70, 86, 65, 23);
		subPanel2.add(boton2Humano);
		
		JRadioButton boton2CPU = new JRadioButton("CPU");
		boton2CPU.setBounds(153, 86, 45, 23);
		subPanel2.add(boton2CPU);
		
		JLabel jugadorColocaFicha = new JLabel("Jugador, coloca ficha");
		jugadorColocaFicha.setHorizontalAlignment(SwingConstants.CENTER);
		jugadorColocaFicha.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		jugadorColocaFicha.setBounds(120, 50, 200, 25);
		add(jugadorColocaFicha);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(133, 418, 237, 61);
		add(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado / mensajes");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 437, 113, 28);
		add(lblNewLabel_2);
		
		/* -----------------LISTENERS -------------------*/
		
		/*-- Se añade Listener al botón de nueva partida.--*/ 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				pc.clickPartida(NombreJugador1, NombreJugador1);
				
			}
		});
		
		//TODO: Listener a los radioButtons para enviarlos al controller
		/*-- Se añade Listeners al botón de nueva partida.--*/ 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				pc.clickPartida(NombreJugador1, NombreJugador1);
				
			}
		});
		
	}	
}

