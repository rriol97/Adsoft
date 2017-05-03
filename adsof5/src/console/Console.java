package console;

import tasks.*; 


public abstract class Console {
	// Atributos
	private Task tareaActual;
	private long tiempoActual;
	
	// Metodos
	
	protected void start(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		stop();
		this.tareaActual = Tasks.getInstance().newTask(args[0]);
		this.tiempoActual = System.currentTimeMillis();
	}
	
	protected void stop(String ...args) {
		if (args.length != 0) {
			throw new IllegalArgumentException("No se deben introducir argumentos");
		}
		long minutos = (System.currentTimeMillis()-this.tiempoActual)/1000;
		spend(""+minutos);
		this.tareaActual = null;
		this.tiempoActual = 0;
	}
	
	protected void addEstimate(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		this.tareaActual.getEstimated().incrementTime(Integer.parseInt(args[0]));
	}
	
	protected void spend(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		this.tareaActual.getDedicated().incrementTime(Integer.parseInt(args[0]));
	}
	
	protected void parent(String ...args) {
		if (args.length > 1) {
			throw new IllegalArgumentException("Se deben introducir 0 o 1 argumentos");
		} else if (args.length == 0) {
			this.tareaActual.setParent(null);
		} else {
			this.tareaActual.setParent(Tasks.getInstance().searchByName(args[0]));
		}
	}
	
	protected void list(String ...args) {
		if (args.length != 0) {
			throw new IllegalArgumentException("No se deben introducir argumentos");
		}
		System.out.println(Tasks.getInstance().getTasksSet());
	}
	
	protected void status(String ...args) {
		if (args.length > 1) {
			throw new IllegalArgumentException("Se deben introducir 0 o 1 argumentos");
		} else if (args.length == 0) {
			System.out.println(this.tareaActual);
		} else {
			System.out.println(Tasks.getInstance().searchByName(args[0]));
		}
	}
}
