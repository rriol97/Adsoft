package tasks;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import observer.*;

public class Tasks implements PropertyObserver<Integer> {
	// Atributos
	private static Tasks Tasks;
	private Set<Task> tasksSet;
	private static TimeProperty estimatedTotal;
	private static TimeProperty dedicatedTotal;
	
	// Metodos
	private Tasks() {
		this.tasksSet = new TreeSet<>();
		estimatedTotal = new TimeProperty();
		dedicatedTotal = new TimeProperty();
		estimatedTotal.addObserver(this);
		dedicatedTotal.addObserver(this);
	}
	
	public static Tasks getInstance(){
		if (Tasks == null) Tasks = new Tasks();
		return Tasks;
	}
	
	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		System.out.println("Tiempo estimado total: "+estimatedTotal.getValue());
		System.out.println("Tiempo dedicado total: "+dedicatedTotal.getValue());
	}
	
	public Set<Task> getTasksSet() {
		return Collections.unmodifiableSet(this.tasksSet);
	}
	
	public static AdjustableTime getEstimatedTotal() {
		return estimatedTotal;
	}
	
	public static AdjustableTime getDedicatedTotal() {
		return dedicatedTotal;
	}
	
	/**
	 * Metodo que nos permite anadir al conjunto de tareas una tarea de forma ordenada
	 * @param taskName nombre de la tarea a anadir
	 * @return La tarea creada 
	 */
	public Task newTask(String taskName) {
		if (searchByName(taskName) == null) {
			Task tarea =  new Task(taskName);
			this.tasksSet.add(tarea);
			estimatedTotal.addProperty(tarea.getEstimated());
			dedicatedTotal.addProperty(tarea.getDedicated());
			return tarea;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Metodo que permite buscar una tarea concreta en el set de tareas ordenadas
	 * @param name nombre de la tarea a encontrar
	 * @return La tarea en cuestion
	 */
	public Task searchByName(String name) {
		for (Task t : this.tasksSet) {
			if (t.getName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		
		return null;
	}
}
