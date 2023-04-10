/**
 * 
 */
package clases;

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
	PlayerSlot playerSlot;
	int playedTurns;
	int score;

	// ------------------- CONSTRUCTORES ---------------------

	/** Constructor por defecto */
	public Player() {
		this.playedTurns = 0;
		this.score = 0;
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
		this.score = 0;
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
		if (this.isHuman = true) {
			typePlayer = "Human";
		} else if (this.isCpu = true) {
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

	/**
	 * @return La puntuacion
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the puntuacion to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/*	*//**
			 * Método que controla el número de jugadas. Si el número de jugada es superior
			 * a 3 se da por finalizado el juego, en caso contrario sumamos +1
			 * 
			 * @param numJugada
			 * @param puntos
			 *//*
				 * public void sumaJugada(int numJugada, int puntos) { if (3 < numJugada) {
				 * System.out.println("FINAL DE JUEGO"); } else { numJugada = numJugada + 1; }
				 * 
				 * }
				 * 
				 * public void checkIfFinal() {
				 * 
				 * }
				 */

}
