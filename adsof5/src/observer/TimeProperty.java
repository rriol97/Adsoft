package observer;

import java.util.ArrayList;
import java.util.List;

public class TimeProperty extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer>{
	// Atributos
	
	// Metodos
	public TimeProperty() {
		this.value = 0;
	}
	
	public void addProperty(ObservableProperty<Integer> p) {
		p.addObserver(this);
		this.incrementTime(p.getValue());
	}
	
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
