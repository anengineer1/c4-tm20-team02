package gui_elements;
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BoardController;
import controller.CpuPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

public class MainView extends JFrame {

	private JPanel contentPane;

	private BoardController board_controller;
	
	private CpuPlayer cpu_player;

	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("TEAM02 - Tick Tack Toe ");
		setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 650);
		
		//--JPane Principal
		this.setBackground(new Color(0, 128, 192));
		//this.setBorder(new EmptyBorder(5, 5, 5, 5));

		//-- Creacion de Layout
		this.setLayout(new GridLayout(1,2));
		
		//Creacion de Paneles 
		//Panel Izquierda: Tablero
		BoardTickTackToe left = new BoardTickTackToe();
		//Panel Derecha
		PanelControl right = new PanelControl();	
		
		this.add(left);
		this.add(right);
		this.setVisible(true);
		
		// Inicialización de la lógica
		this.board_controller = new BoardController(left); // controlling ticktacktoe
		this.cpu_player = new CpuPlayer(this.board_controller, false, true);
		// Probando cpu
	}

}
