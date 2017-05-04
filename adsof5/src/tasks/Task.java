package tasks;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import observer.*;

public class Task implements Comparable<Task> {
	// Atributos
	private final String name;
	private Task parent;
	private Set<Task> subTasks;
	private TimeProperty estimated;
	private TimeProperty dedicated;
	
	// Metodos
	public Task(String name) {
		this.name = name;
		this.subTasks = new TreeSet<>();
		this.dedicated = new TimeProperty();
		this.estimated = new TimeProperty();
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Metodo que nos permite anadir una subtarea a una tarea
	 * @param t subtarea a anadir
	 * @return true si se hizo correctamete, false en caso contrario
	 */
	public boolean addTask(Task t) {
		if (this.containsTask(t)){
			return false;
		}
		
		if (t.getParent() != null && !this.equals(t.getParent())){
			throw new IllegalArgumentException();
		}
		
		if (t.parent == null) {
			Tasks.getInstance().removeRoot(t);
		}
		
		t.parent = this;
		this.subTasks.add(t);
		this.estimated.addProperty(t.estimated);
		this.dedicated.addProperty(t.dedicated);
		return true;
	}
	
	/**
	 * Metodo que nos permite eliminar una subtarea de una tarea
	 * @param t subtarea a eliminar
	 * @return true si se hizo correctamete, false en caso contrario
	 */
	public boolean removeTask(Task t) {
		if (!this.containsTask(t)){
			return false;
		}
		
		Tasks.getInstance().addRoot(t);
		
		t.parent = null;
		this.subTasks.remove(t);
		this.estimated.removeProperty(t.estimated);
		this.dedicated.removeProperty(t.dedicated);
		return true;
	}
	
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(this.subTasks);
	}
	
	/**
	 * Metodo que nos permite ver si una tarea esta contenida en esta tarea
	 * @param t Tarea a buscar en las subtareas
	 * @return true si se hizo correctamete, false en caso contrario
	 */
	public boolean containsTask(Task t) {
		Set<Task> subTasks = this.getTasks();
		if (subTasks.isEmpty()) {
			return false;
		}
		
		if (subTasks.contains(t)) {
			return true;
		} else {
			for (Task tk : subTasks) {
				if (tk.containsTask(t)) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Metodo que nos devuelve la tarea padre
	 * @param parent Tarea padre
	 * @throws IllegalArgumentException Argumento incorrecto
	 */
	public void setParent(Task parent) throws IllegalArgumentException{
		if (this.containsTask(parent)){
			throw new IllegalArgumentException();
		}
		
		if (this.parent != null) {
			this.parent.removeTask(this);	
		}
					
		if (parent != null){
			parent.addTask(this);
		}
	}
	
	public Task getParent() {
		return this.parent;
	}
	
	public AdjustableTime getEstimated() {
		return this.estimated;
	}
	
	public AdjustableTime getDedicated() {
		return this.dedicated;
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
		if (!(o instanceof Task)){
			return false;
		}
		
		Task t = (Task)o;
		
		return this.name.equals(t.getName());
	}

	@Override
	public int compareTo(Task o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString(){
		String ret = this.name+" (Tarea Padre = ";
		if (this.parent == null) {
			ret += "Ninguna";
		} else {
			ret += this.parent.getName();
		}
		return ret += ") (Tiempo estimado = "+this.getEstimated()+
				") (Tiempo dedicado = "+this.getDedicated()+")";
	}

	
}
