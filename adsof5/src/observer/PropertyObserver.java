package observer;

/**
 * Interfaz que define el comportamiento de un observador a una propiedad observable.
 * 
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
public interface PropertyObserver<V> {
	/**
	 * Metodo que nos permite hacer que los observadores de una propiedad observable reaccionen a cambios en el valor de dicha propiedad
	 * @param property propiedad a la que se observa
	 * @param oldValue valor antiguo de dicha propiedad observable
	 */
	void propertyChanged(ObservableProperty<V> property, V oldValue);
}
