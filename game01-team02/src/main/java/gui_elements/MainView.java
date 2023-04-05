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
import controller.PanelController;

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
	
	private BoardTickTackToe left;
	
	private PanelController panel_controller;
	private PanelControl right;
	
	private CpuPlayer cpu_player;

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
		this.left = new BoardTickTackToe();
		//Panel Derecha
		this.right = new PanelControl(panel_controller);	
		
		this.add(left);
		this.add(right);
		this.setVisible(true);
		
		
		//BOARDCONTROLLER
		// Inicialización de la lógica
		this.board_controller = new BoardController(left); // controlling ticktacktoe
		this.cpu_player = new CpuPlayer(this.board_controller, false, true);
		// Probando cpu
		
		//PANELCONTROLLER
		this.panel_controller = new PanelController(left, right);
		
	}
	
	public BoardTickTackToe getBoard() {
		return this.left;
	}

	public PanelControl getPanelControl() {
		return this.right;
	}
	
	
}
