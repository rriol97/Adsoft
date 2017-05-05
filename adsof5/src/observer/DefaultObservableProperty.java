package observer;

import java.util.List;
import java.util.ArrayList;

public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>{
	// Atributos
	private List<PropertyObserver<V>> observers;
	protected V value;
	
	// Metodos
	public DefaultObservableProperty() {
		observers = new ArrayList<>();
	}
	
	/**
	 * Metodo que nos permite cambiar el valor 
	 * @param newValue El nuevo valor 
	 */
	protected void setValue(V newValue) {
		if (!this.value.equals(newValue)) {
			V oldValue = this.value;
			this.value = newValue;
			for (PropertyObserver<V> ob : this.observers) {
				if (ob != null) {
					ob.propertyChanged(this, oldValue);
				} else {
					System.out.println("Hola");
				}
			}
		}
	}
	
	@Override
	public V getValue() {
		return this.value;
	}
	
	@Override
	public void addObserver(PropertyObserver<V> o) {
		this.observers.add(o);
	}
	
	@Override
	public void removeObserver(PropertyObserver<V> o) {
		this.observers.remove(o);
	}
	

	
	
	
}
