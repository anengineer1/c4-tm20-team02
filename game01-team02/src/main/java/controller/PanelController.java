/**
 * 
 */
package controller;

import javax.swing.JTextField;
import clases.Jugador;
import gui_elements.BoardTickTackToe;
import gui_elements.PanelControl;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class PanelController {

	/**
	 * 
	*/
	/*
	 * Jugador j1 = new Jugador(); Jugador j2 = new Jugador();
	 * 
	 * J1 = new Jugador(j1.getText(), j2.getText()); J2 = new Jugador(j2.getText(),
	 * j2.getText());
	 */
	BoardTickTackToe leftSide;
	PanelControl rightSide;
	BoardController boardC;

	//public PanelController() {}

	public PanelController(BoardTickTackToe left, PanelControl right) {
		this.leftSide = left;
		this.rightSide = right;
		this.boardC = new BoardController(left);
	}

	/*-- Boton de Nueva Partida: 
	 * Comienza la partida con los parametros seleccionados por el usuario
	 * @params
	 * --*/

	/*
	 * TODO: añadir radiobuttons como parametros, una vez incluidos los listeners.
	 */
	public void clickPartida(String j1, String j2, String tipo1, String tipo2) {
		System.out.println("Hola");
		//System.out.println(j1.getText());
		
		/*-- Creamos los jugadores --*/
		
		Jugador J1 =  new Jugador();
		Jugador J2 =  new Jugador();
		
		/* TODO: discriminar radiobutton true 
		* y enviar el tipo radioButtons
		* al constructor del jugador. */
		/*--Incluimos los datos de los jugadores --*/

		J1 =  new Jugador(j1, tipo1);
		J2 =  new Jugador(j2, tipo2);
		
		//Reseteo de tablero.
		boardC.clearButtons();
		System.out.println(J1.getTipo());
		System.out.println(J2.getTipo());

	}		
}
