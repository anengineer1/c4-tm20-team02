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
import controller.PanelController;
import models.CpuPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

public class MainView extends JFrame {

	private JPanel contentPane;
	private PanelController panel_controller;
	//private BoardController board_controller;
	private BoardTickTackToe left;
	private PanelControl right;
	private CpuPlayer cpu_player;

	/**
	 * Constructor que crea la ventana principal del juego
	 */
	public MainView() {
		setTitle("TEAM02 - Tick Tack Toe ");
		setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1159, 650);
		
		//--JPane Principal
		this.setBackground(new Color(0, 128, 192));
		//this.setBorder(new EmptyBorder(5, 5, 5, 5));

		//-- Creacion de Layout
		getContentPane().setLayout(new GridLayout(1,2));
		
		//Creacion de Paneles 
		//Panel Izquierda: Tablero
		this.left = new BoardTickTackToe();
		//Panel Derecha
		this.right = new PanelControl(panel_controller);	
		
		getContentPane().add(left);
		getContentPane().add(right);
		this.setVisible(true);
		
		
		//BOARDCONTROLLER
		// Inicialización de la lógica
		//this.board_controller = new BoardController(left); // controlling ticktacktoe


		//PANELCONTROLLER
		this.panel_controller = new PanelController(left, right);
		
	}
	
	/**
	 * Metodo que devuelve el objeto correspondiente a la parte izquierda de la ventana (las casillas)
	 * @return objeto BoardTickTackToe
	 */
	/*
	 * public BoardTickTackToe getBoard() { return this.left; }
	 */

	/**
	 * Metodo que devuelve el objeto correspondiente a la parte derecha de la ventana (panel de control)
	 * @return objeto PanelControl
	 */
	public PanelControl getPanelControl() {
		return this.right;
	}
	
	
}
