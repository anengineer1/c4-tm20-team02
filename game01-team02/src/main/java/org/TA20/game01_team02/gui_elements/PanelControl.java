package org.TA20.game01_team02.gui_elements;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PanelControl {

	private JFrame frame;
	private JTextField NombreJugador1;
	private JTextField NombreJugador2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelControl window = new PanelControl();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelControl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Nueva Partida");
		btnNewButton.setBounds(169, 11, 120, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Jugador 1");
		lblNewLabel.setBounds(24, 47, 60, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(24, 86, 60, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		NombreJugador1 = new JTextField();
		NombreJugador1.setBounds(94, 86, 106, 22);
		frame.getContentPane().add(NombreJugador1);
		NombreJugador1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setBounds(24, 133, 60, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JRadioButton boton1Humano = new JRadioButton("Humano");
		boton1Humano.setBounds(94, 133, 65, 23);
		frame.getContentPane().add(boton1Humano);
		
		JRadioButton boton1CPU = new JRadioButton("CPU");
		boton1CPU.setBounds(172, 133, 53, 23);
		frame.getContentPane().add(boton1CPU);
		
		JLabel lblJugador = new JLabel("Jugador 2");
		lblJugador.setBounds(24, 188, 60, 28);
		frame.getContentPane().add(lblJugador);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre");
		lblNewLabel_1_2.setBounds(24, 227, 60, 22);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		NombreJugador2 = new JTextField();
		NombreJugador2.setColumns(10);
		NombreJugador2.setBounds(94, 227, 106, 22);
		frame.getContentPane().add(NombreJugador2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1_1.setBounds(24, 274, 60, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JRadioButton boton2Humano = new JRadioButton("Humano");
		boton2Humano.setBounds(94, 274, 65, 23);
		frame.getContentPane().add(boton2Humano);
		
		JRadioButton boton2CPU = new JRadioButton("CPU");
		boton2CPU.setBounds(172, 274, 53, 23);
		frame.getContentPane().add(boton2CPU);
	}
}
