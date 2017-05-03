package console;

import tasks.*; 


public abstract class Console {
	// Atributos
	private Task tareaActual;
	private long tiempoActual;
	
	// Metodos
	public Console() {
		
	}
	
	private void start(String taskName) {
		stop();
		this.tareaActual = Tasks.getInstance().newTask(taskName);
		this.tiempoActual = System.currentTimeMillis();
	}
	
	private void stop() {
		long minutos = (System.currentTimeMillis()-this.tiempoActual)/1000;
		spend((int)minutos);
		this.tareaActual = null;
		this.tiempoActual = 0;
	}
	
	private void addEstimate(int minutos) {
		this.tareaActual.getEstimated().incrementTime(minutos);
	}
	
	private void spend(Integer minutos) {
		this.tareaActual.getDedicated().incrementTime(minutos);
	}
	
	private void parent(String ...parentTask) {
		if (parentTask.length == 0) {
			this.tareaActual.setParent(null);
		} else {
			this.tareaActual.setParent(Tasks.getInstance().searchByName(parentTask[0]));
		}
	}
	
	private void list() {
		System.out.println(Tasks.getInstance().getTasksSet());
	}
	
	private void status(String ...taskName) {
		if (taskName.length == 0) {
			System.out.println(this.tareaActual);
		} else {
			System.out.println(Tasks.getInstance().searchByName(taskName[0]));
		}
	}
}
