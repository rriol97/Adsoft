package tasks;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Tasks {
	// Atributos
	private static Tasks Tasks = new Tasks();
	private Set<Task> taskSet;
	
	// Metodos
	private Tasks() {
		this.taskSet = new TreeSet<>();
	}
	
	public static Tasks getInstance(){
		return Tasks;
	}
	
	public Set<Task> getTasksSet() {
		return Collections.unmodifiableSet(this.taskSet);
	}
	
	public Task newTask(String taskName, Integer dedicated) {
		if (searchByName(taskName) == null) {
			Task tarea =  new Task(taskName, dedicated);
			this.taskSet.add(tarea);
			return tarea;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Task searchByName(String name) {
		for (Task t : this.taskSet) {
			if (t.getName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		
		return null;
	}
}
