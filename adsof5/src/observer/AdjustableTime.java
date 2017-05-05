package observer;

/**
 * Interfaz que define el comportamiento de de una propiedad observable de tiempo
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
public interface AdjustableTime extends ObservableProperty<Integer> {
	/**
	 * Metodo que nos permite incrementar el valor de una propiedad observable (este caso un entero).
	 * @param inc Incremento a sumar.
	 */
	void incrementTime(int inc);
}
