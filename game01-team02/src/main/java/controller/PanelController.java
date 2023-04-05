/**
 * 
 */
package controller;

/**
 * 
 */
import javax.swing.JTextField;

import clases.Jugador;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class PanelController {

	/**
	 * 
	 */
	public PanelController() {
	}

	
	/*-- Boton de Nueva Partida: 
	 * Comienza la partida con los parametros seleccionados por el usuario
	 * @params
	 * --*/ 
	
	/*TODO: añadir radiobuttons como parametros, una vez incluidos los listeners.
	public void clickPartida(JTextField j1, JTextField j2) {
		System.out.println("Hola");
		System.out.println(j1.getText());
		
		/*-- Creamos los jugadores --*/
		Jugador J1 =  new Jugador();
		Jugador J2 =  new Jugador();
		
		/* TODO: discriminar radiobutton true 
		* y enviar el tipo radioButtons
		* al constructor del jugador. */
		/*--Incluimos los datos de los jugadores --*/
		J1 =  new Jugador(j1.getText(), j2.getText());
		J2 =  new Jugador(j2.getText(), j2.getText());
		
	}
	
}
