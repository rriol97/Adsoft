package observer;

public interface AdjustableTime extends ObservableProperty<Integer> {
	/**
	 * Metodo que nos permite incremetar el valor de una propiedad observable (este caso un entero).
	 * @param inc Incremento a sumar.
	 */
	void incrementTime(int inc);
}
