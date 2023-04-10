/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.CpuPlayer;
import clases.Player;
import clases.PlayerSlot;
import gui_elements.BoardTickTackToe;
import gui_elements.PanelControl;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class PanelController {

	private BoardTickTackToe leftSideView;
	private PanelControl rightSideView;
	private BoardController boardC;
	// Modelo
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

	/*-- Boton de Nueva Partida: 
	 * Comienza la partida con los parametros seleccionados por el usuario
	 * @params
	 * --*/
	/*
	 * TODO: añadir radiobuttons como parametros, una vez incluidos los listeners.
	 */
	// public void clickPartida(String j1, String j2, String tipo1, String tipo2) {
	public void clickNewGame() {

		/*
		 * TODO: discriminar radiobutton true y enviar el tipo radioButtons al
		 * constructor del jugador.
		 */
		/*--Incluimos los datos de los jugadores --*/

		/*-- Create the players with introduced values by user in panel control --*/
		players[0] = new Player(rightSideView.NombreJugador1.getText(), rightSideView.group1Selected);
		players[1] = new Player(rightSideView.NombreJugador2.getText(), rightSideView.group2Selected);

		// Reset the board
		boardC.restartGame();
		
		// Si cpu está activa de la partida anterior, borrarla
		if (cpuPlayerModel != null) {
			cpuPlayerModel = null;
			boardC.unSetCpuPlayer();
		}

		// TODO: Chequear si los 2 players son CPU

		if (players[0].getType() == "CPU") {
			cpuPlayerModel = new CpuPlayer(boardC, PlayerSlot.PLAYER_1);
		} else {
//TODO: Error
		}
		if (players[1].getType() == "CPU") {
			cpuPlayerModel = new CpuPlayer(boardC, PlayerSlot.PLAYER_2);
		} else {
			// TODO: Error
		}

		boardC.setPrintResults(rightSideView.textPane, rightSideView.jugadorColocaFicha, players);

		System.out.println(players[0].getName() + " " + players[0].getType());

	}

	public void initGame() {
		// Init the board

		// this.cpu_player = new CpuPlayer(this.board_controller, false, true);
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

		/*-- Se añade Listeners RADIOBUTTONS.--*/		
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

		/* Listeners Radiobuttons */
		rightSideView.boton1Humano.addActionListener(send1);
		rightSideView.boton2Humano.addActionListener(send2);
		rightSideView.boton1CPU.addActionListener(send1);
		rightSideView.boton2CPU.addActionListener(send2);

	}
}
