package observer;

public interface AdjustableTime extends ObservableProperty<Integer> {
	void incrementTime(int inc);
}
