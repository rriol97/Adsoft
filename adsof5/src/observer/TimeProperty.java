package observer;

public class TimeProperty extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer>{
	// Atributos
	
	// Metodos
	public TimeProperty() {
		this.value = 0;
	}
	
	/**
	 * Metodo que nos permite anadir una propiedad observable (un entero).
	 * @param p propiedad observable a anadir
	 */
	public void addProperty(ObservableProperty<Integer> p) {
		p.addObserver(this);
		this.incrementTime(p.getValue());
	}
	
	/**
	 * Metodo que nos permite eliminar una propiedad observable (un entero).
	 * @param p propiedad observable a eliminar
	 */
	public void removeProperty(ObservableProperty<Integer> p) {
		p.removeObserver(this);
		this.incrementTime(-p.getValue());
	}
	
	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		this.incrementTime(property.getValue() - oldValue);
	}
	
	@Override
	public void incrementTime(int inc) {
		if (inc == 0) return;
		Integer time = this.getValue();
		time += inc;
		
		if (time < 0) {
			throw new IllegalArgumentException();
		} else {
			this.setValue(time);
		}
	}
	
	public String toString(){
		return this.value.toString();
	}

}
