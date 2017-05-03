package console;

import tasks.*; 


public abstract class Console {
	// Atributos
	private Task tareaActual;
	private long tiempoActual;
	
	// Metodos
	
	/**
	 * Metodo que nos permite crear una tarea y ejecutarla 
	 * @param args Nombre de la nueva tarea
	 */
	protected void start(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		if (this.tareaActual != null) {
			stop();
		}
		this.tareaActual = Tasks.getInstance().newTask(args[0]);
		this.tiempoActual = System.currentTimeMillis();
	}
	
	/*
	 * Metodo que nos permite detener la ejecucion de una tarea
	 */
	protected void stop(String ...args) {
		if (args.length != 0) {
			throw new IllegalArgumentException("No se deben introducir argumentos");
		}
		
		long minutos = (System.currentTimeMillis()-this.tiempoActual)/1000;
		spend(((Long)minutos).toString());
		this.tareaActual = null;
		this.tiempoActual = 0;
	}
	/**
	 * Metodo que nos permite establecer el tiempo estimado de la tarea actual
	 * @param args Minutos de tiempo estimado a anadir
	 */
	protected void addEstimate(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		
		if (this.tareaActual == null) {
			throw new IllegalArgumentException("No existe ninguna tarea actual");
		}
		
		this.tareaActual.getEstimated().incrementTime(Integer.parseInt(args[0]));
	}
	
	/**
	 * Metodo que permite ver cuanto tiempo lleva la tarea ejecutandose
	 * @param args Nombre de la tarea
	 */
	protected void spend(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		
		if (this.tareaActual == null) {
			throw new IllegalArgumentException("No existe ninguna tarea actual");
		}
		
		this.tareaActual.getDedicated().incrementTime(Integer.parseInt(args[0]));
	}
	
	/**
	 * Metodo que nos permite obtener el padre de una tarea
	 * @param args Tarea de la cual queremos obtener su padre. Si no se especifica ninguna se dara el padre de la tarea actual.
	 */
	protected void parent(String ...args) {
		if (this.tareaActual == null) {
			throw new IllegalArgumentException("No existe ninguna tarea actual");
		}
		
		if (args.length > 1) {
			throw new IllegalArgumentException("Se deben introducir 0 o 1 argumentos");
		} else if (args.length == 0) {
			this.tareaActual.setParent(null);
		} else {
			this.tareaActual.setParent(Tasks.getInstance().searchByName(args[0]));
		}
	}
	
	/**
	 * Metodo que obtiene e imprime el arbol de tareas
	 * @param args (no argumentos)
	 */
	protected void list(String ...args) {
		if (args.length != 0) {
			throw new IllegalArgumentException("No se deben introducir argumentos");
		}
		System.out.println(Tasks.getInstance().getTasksSet());
	}
	
	/**
	 * Metodo que permite obtener la tarea actual
	 * @param args (no argumentos)
	 */
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
