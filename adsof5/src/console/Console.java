package console;

import tasks.*; 

/**
 * Clase abstracta que implementa los comandos (funciones que derivan de la interfaz function) y define los atributos de la futura consola 
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
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
			throw new IllegalArgumentException("Se debe introducir un único argumento");
		}
		if (this.tareaActual != null) {
			stop();
		}
		
		try {
			this.tareaActual = Tasks.getInstance().newTask(args[0]);
		} catch (IllegalArgumentException e) {
			this.tiempoActual = System.currentTimeMillis();
			this.tareaActual = Tasks.getInstance().searchByName(args[0]);
			throw new IllegalArgumentException("Ya existe una tarea creada con ese nombre. "
					+ "Se reanuda su ejecución");
		}
		this.tiempoActual = System.currentTimeMillis();
	}
	
	/**
	 * Metodo que nos permite detener la ejecucion de una tarea
	 * @param args (sin argumentos)
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
	 * @param args Minutos de tiempo estimado a anyadir
	 */
	protected void addEstimate(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		
		if (this.tareaActual == null) {
			throw new IllegalArgumentException("No existe ninguna tarea actual");
		}
		
		try {
			this.tareaActual.getEstimated().incrementTime(Integer.parseInt(args[0]));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("El argumento introducido no es un entero");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El ajuste no puede dar un número negativo");
		}
	}
	
	/**
	 * Metodo que permite anyadir minutos al tiempo dedicado de la tarea actual
	 * @param args Minutos de tiempo dedicado a anyadir
	 */
	protected void spend(String ...args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Se debe introducir solo un argumento");
		}
		
		if (this.tareaActual == null) {
			throw new IllegalArgumentException("No existe ninguna tarea actual");
		}
		
		try {
			this.tareaActual.getDedicated().incrementTime(Integer.parseInt(args[0]));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("El argumento introducido no es un entero");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El ajuste no puede dar un número negativo");
		}
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
			Task t;
			if ((t = Tasks.getInstance().searchByName(args[0])) == null) {
				throw new IllegalArgumentException("No existe ninguna tarea con ese nombre");
			} else {
				try {
					this.tareaActual.setParent(t);
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException("Acción inválida");
				}
			}
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
	 * Metodo que permite imprimir una tarea en concreto o si no, la tarea actual
	 * @param args el nombre de la tarea actual o nada
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
