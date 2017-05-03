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
	public Task(String name, Integer estimated) {
		this.name = name;
		this.subTasks = new TreeSet<>();
		this.dedicated = new TimeProperty();
		this.estimated = new TimeProperty();
		this.estimated.setValue(estimated);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean addTask(Task t) {
		t.setParent(this);
		this.subTasks.add(t);
		this.estimated.addProperty(t.estimated);
		this.dedicated.addProperty(t.dedicated);
		return true;
	}
	
	public boolean removeTask(Task t) {
		if (this.containsTask(t)==false){
			return false;
		}
		t.setParent(null);
		this.subTasks.remove(t);
		this.estimated.removeProperty(t.estimated);
		this.dedicated.removeProperty(t.dedicated);
		return true;
	}
	
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(this.subTasks);
	}
	
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
	
	public void setParent(Task t) {
		this.parent = t;
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
	public int compareTo(Task o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString(){
		return this.name+" (Tiempo estimado = "+this.getEstimated()+")";
	}

	
}
