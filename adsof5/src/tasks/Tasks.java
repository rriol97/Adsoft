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
	/**
	 * Metodo que nos permite anadir al conjunto de tareas una tarea de forma ordenada
	 * @param taskName nombre de la tarea a anadir
	 * @return La tarea creada 
	 */
	public Task newTask(String taskName) {
		if (searchByName(taskName) == null) {
			Task tarea =  new Task(taskName);
			this.tasksSet.add(tarea);
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
