/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import clases.Player;
import clases.PlayerSlot;
import gui_elements.BoardTickTackToe;
import gui_elements.PanelControl;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class PanelController {

	@SuppressWarnings("unused")
	private BoardTickTackToe leftSideView;
	private PanelControl rightSideView;
	private BoardController boardC;
	// Modelo
	@SuppressWarnings("unused")
	private Player playerModel;
	private CpuPlayer cpuPlayerModel;
	// Players array
	// Save the 2 players of game
	private Player[] players;
	private ActionListener send1, send2;

	// public PanelController(BoardTickTackToe left, PanelControl right, Player
	// player, PlayerSlot playerSlot) {
	public PanelController(BoardTickTackToe left, PanelControl right) {
		this.leftSideView = left;
		this.rightSideView = right;
		this.boardC = new BoardController(left);
		this.players = new Player[2];

		initListeners();

	}

	/*-- New Game Button: 
	 * Start the game with params selected for user.
	 * @params
	 **/
	public void clickNewGame() {

		/*-- Create the players with introduced values by user in panel control --*/
		players[0] = new Player(rightSideView.NombreJugador1.getText(), rightSideView.group1Selected);
		players[1] = new Player(rightSideView.NombreJugador2.getText(), rightSideView.group2Selected);

		// Reset the board
		boardC.restartGame();
		//Clean text field results
		rightSideView.textPane.setText("");
		//Clean the label of turn
		rightSideView.jugadorColocaFicha.setText("");
		
		// If cpu is active from last game, delete it
		if (cpuPlayerModel != null) {
			cpuPlayerModel = null;
			boardC.unSetCpuPlayer();
		}

		// Check if 2 players are CPU
		if (players[0].getType() == "CPU" && players[1].getType() == "CPU") {
			JOptionPane.showMessageDialog(null, "Error getting player type." + "\nOnly can exist one player CPU",
					"Error: End Game", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// Inicialize CPU Player in the case of has been selected
		if (players[0].getType() == "CPU") {
			cpuPlayerModel = new CpuPlayer(boardC, PlayerSlot.PLAYER_1);
		}

		if (players[1].getType() == "CPU") {
			cpuPlayerModel = new CpuPlayer(boardC, PlayerSlot.PLAYER_2);
		}

		//Set the first turn label of PLAYER_1
		rightSideView.jugadorColocaFicha.setText("Turno de Jugador 1 " + players[0].getName());
		
		// Print results in textfield
		boardC.setPrintResults(rightSideView.textPane, rightSideView.jugadorColocaFicha, players);
	}

	/*
	 * Init Listeners of control panel.
	 */
	public void initListeners() {

		/*-- Button New Game Listener --*/
		rightSideView.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// System.out.println(rightSideView.NombreJugador1.getText());
				// System.out.println(rightSideView.NombreJugador2.getText());
				System.out.println(rightSideView.group1Selected);
				System.out.println(rightSideView.group2Selected);
				// clickPartida(rightSideView.NombreJugador1.getText(),
				// rightSideView.NombreJugador2.getText(),rightSideView.group1Selected,rightSideView.group2Selected);

				clickNewGame();
			}
		});

		/* 
		 * Add Listeners radiobuttons: send1 y send2
		 */
		this.send1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedBoxes = new ArrayList<String>();

				if (rightSideView.boton1Humano.isSelected()) {
					selectedBoxes.add(rightSideView.boton1Humano.getText());
				}

				if (rightSideView.boton1CPU.isSelected()) {
					selectedBoxes.add(rightSideView.boton1CPU.getText());
				}

				Enumeration<AbstractButton> allRadioButton = rightSideView.group1.getElements();
				while (allRadioButton.hasMoreElements()) {
					JRadioButton temp = (JRadioButton) allRadioButton.nextElement();
					if (temp.isSelected()) {
						rightSideView.group1Selected = temp.getText();

					}
				}
			}
		};

		this.send2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedBoxes = new ArrayList<String>();

				if (rightSideView.boton2Humano.isSelected()) {
					selectedBoxes.add(rightSideView.boton2Humano.getText());
				}

				if (rightSideView.boton2CPU.isSelected()) {
					selectedBoxes.add(rightSideView.boton2CPU.getText());
				}

				Enumeration<AbstractButton> allRadioButton = rightSideView.group2.getElements();
				while (allRadioButton.hasMoreElements()) {
					JRadioButton temp = (JRadioButton) allRadioButton.nextElement();
					if (temp.isSelected()) {
						rightSideView.group2Selected = temp.getText();
						System.out.println(temp.getText());

					}
				}
			}
		};

		/* -----------------LISTENERS ------------------- */

		/*Add Listeners Radiobuttons */
		rightSideView.boton1Humano.addActionListener(send1);
		rightSideView.boton2Humano.addActionListener(send2);
		rightSideView.boton1CPU.addActionListener(send1);
		rightSideView.boton2CPU.addActionListener(send2);

	}
}
