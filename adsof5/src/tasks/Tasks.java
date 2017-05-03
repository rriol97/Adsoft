package tasks;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Tasks {
	// Atributos
	private static Tasks Tasks = new Tasks();
	private Set<Task> tasksSet;
	
	// Metodos
	private Tasks() {
		this.tasksSet = new TreeSet<>();
	}
	
	public static Tasks getInstance(){
		return Tasks;
	}
	
	public Set<Task> getTasksSet() {
		return Collections.unmodifiableSet(this.tasksSet);
	}
	
	public Task newTask(String taskName) {
		if (searchByName(taskName) == null) {
			Task tarea =  new Task(taskName);
			this.tasksSet.add(tarea);
			return tarea;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Task searchByName(String name) {
		for (Task t : this.tasksSet) {
			if (t.getName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		
		return null;
	}
}
