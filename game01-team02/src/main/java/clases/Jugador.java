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
	/*-- Constructor por defecto --*/
	public Jugador() {
		this.numJugadas = 0;
		this.puntuacion = 0;
	}

	/*-- Constructor por defecto --*/
	public Jugador(String nombre, String tipo) {
		this.Nombre = nombre;
		this.isHumano = true;
		this.numJugadas = 0;
		this.puntuacion = 0;
	}

	// ------------------- Getters y Setters ---------------------

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the tipo
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
	 * @return the numJugadas
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
	 * @return the puntuacion
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
