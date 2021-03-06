package observer;

import java.util.List;
import java.util.ArrayList;
/**
 * Clase anonima que implementa los metodos y define los atributos de cualquier propiedad observable
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
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
