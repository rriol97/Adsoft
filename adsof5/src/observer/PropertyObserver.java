package observer;

public interface PropertyObserver<V> {
	/**
	 * Metodo que nos permite hacer que los observadores de una propiedad observable reaccionen a cambios en el valor de dicha propiedad
	 * @param property propiedad a la que se observa
	 * @param oldValue valor antiguo de dicha propiedad observable
	 */
	void propertyChanged(ObservableProperty<V> property, V oldValue);
}
