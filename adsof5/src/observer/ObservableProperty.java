package observer;

public interface ObservableProperty<V> {
	
	/**
	 * Metodo que nos devuelve el valor de una propiedad observable
	 * @return El valor en cuestion
	 */
	V getValue();
	
	/**
	 * Metodo que nos permite anadir observadores a una propiedad observable
	 * @param o Observador a anadir al conjunto de observadores de la propiedad
	 */
	void addObserver(PropertyObserver<V> o);
	
	/**
	 * Metodo que nos permite eliminar observadores de una propiedad observable
	 * @param o  Observador a eliminar del conjunto de observadores de la propiedad observable
	 */
	void removeObserver(PropertyObserver<V> o);
}

