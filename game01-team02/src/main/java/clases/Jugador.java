/**
 * 
 */
package clases;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class Jugador {

	// ------------------- Atributos ---------------------
	String Nombre;
	Boolean isHumano;
	int numJugadas;
	int puntuacion;

	// ------------------- CONSTRUCTORES ---------------------
	
	/** Constructor por defecto */
	public Jugador() {
		this.numJugadas = 0;
		this.puntuacion = 0;
	}

	/**
	 * Constructor por defecto con nombre y tipo como parámetros
	 * @param nombre
	 * @param tipo
	 */
	public Jugador(String nombre, String tipo) {
		this.Nombre = nombre;
		this.isHumano = true;
		this.numJugadas = 0;
		this.puntuacion = 0;
	}

	// ------------------- Getters y Setters ---------------------

	/**
	 * @return Nombre del jugador
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param Nombre del jugador
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return El tipo
	 */
	public Boolean getTipo() {
		return isHumano;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.isHumano = isHumano;
	}

	/**
	 * @return El número de jugadas
	 */
	public int getNumJugadas() {
		return numJugadas;
	}

	/**
	 * @param numJugadas the numJugadas to set
	 */
	public void setNumJugadas(int numJugadas) {
		this.numJugadas = numJugadas;
	}

	/**
	 * @return La puntuacion
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * @param puntuacion the puntuacion to set
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * Método que controla el número de jugadas.
	 * Si el número de jugada es superior a 3 se da por finalizado el juego,
	 * en caso contrario sumamos +1
	 * @param numJugada
	 * @param puntos
	 */
	public void sumaJugada(int numJugada, int puntos) {
		if (3<numJugada) {
			System.out.println("FINAL DE JUEGO");
		}else {
			 numJugada = numJugada + 1;
		}
		
	}
	
	public void checkIfFinal() {
		
	}
	
}
