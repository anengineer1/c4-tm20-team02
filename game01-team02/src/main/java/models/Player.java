/**
 * 
 */
package models;

import javax.swing.JOptionPane;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class Player {

	// ------------------- Atributos ---------------------
	String Name;
	Boolean isHuman;
	Boolean isCpu;
	int playedTurns;

	// ------------------- CONSTRUCTORES ---------------------

	/** Constructor por defecto */
	public Player() {
		this.playedTurns = 0;
	}
	/**
	 * Constructor por defecto con nombre y tipo como parámetros
	 * 
	 * @param nombre
	 * @param type
	 */
	public Player(String nombre, String type) {
		this.Name = nombre;

		/*
		 * Check user type param and inicialize isHuman and isCpu
		 */
		if (type == "Humano") {
			this.isHuman = true;
			this.isCpu = false;
		} else if (type == "CPU") {
			this.isHuman = false;
			this.isCpu = true;
		} else {
			JOptionPane.showMessageDialog(null, "Error selecting player type", "Error: End Game",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		this.playedTurns = 0;
	}

	// ------------------- Getters y Setters ---------------------

	/**
	 * @return Nombre del jugador
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param Name del jugador
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return El tipo
	 */
	public String getType() {
		String typePlayer = "";
		/*
		 * Check type player methods and return the type user in string
		 */
		if (this.isHuman == true) {
			typePlayer = "Human";
		} else if (this.isCpu == true) {
			typePlayer = "CPU";
		} else {
			JOptionPane.showMessageDialog(null, "Error getting player type", "Error: End Game",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		return typePlayer;
	}

	/**
	 * @param type the tipo to set
	 */
	public void setType(String type) {
		/*
		 * Check user type param and inicialize isHuman and isCpu
		 */
		if (type == "Humano") {
			this.isHuman = true;
			this.isCpu = false;
		} else if (type == "CPU") {
			this.isHuman = false;
			this.isCpu = true;
		} else {
			JOptionPane.showMessageDialog(null, "Error selecting player type", "Error: End Game",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * @return El número de jugadas
	 */
	public int getPlayedTurns() {
		return playedTurns;
	}

	/**
	 * @param playedTurns the numJugadas to set
	 */
	public void setPlayedTurns(int playedTurns) {
		this.playedTurns = playedTurns;
	}


	@Override
	public String toString() {
		
		return "\nPlayer:  " + Name + " -  es CPU: " + isCpu + " -  Turnos Jugados: " + playedTurns
				+ "\n";
	}



}
