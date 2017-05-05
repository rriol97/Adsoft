package testers;

import tasks.Task;
import tasks.Tasks;
/**
 * Clase que prueba la funcionalidad de las tareas del apartado 2.
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
public class testerApartado2 {

	public static void main(String[] args) {
		
		//Creamos tareas para poder "jugar" con ellas
		Task tarea1 = Tasks.getInstance().newTask("Practica ADSOFT");
		Task tarea2 = Tasks.getInstance().newTask("Practica PADSOFT");
		Task tarea3 = Tasks.getInstance().newTask("Examen SOPER");
		Task tarea4 = Tasks.getInstance().newTask("Examen LAB");
		Task tarea5 = Tasks.getInstance().newTask("Examen CN");
		
		//Le damos valores iniciales a nuestras tareas (tiempo estimado)
		tarea4.getEstimated().incrementTime(4);
		tarea5.getEstimated().incrementTime(2);
		
		//(tiempo dedicado)
		tarea1.getDedicated().incrementTime(7);
		tarea2.getDedicated().incrementTime(3);
		tarea3.getDedicated().incrementTime(9);

		
		//Creamos la estructura del arbol
		tarea5.addTask(tarea3);
		tarea3.addTask(tarea4);
		tarea3.addTask(tarea2);
		tarea2.addTask(tarea1);
		
		//Realizamos algunas comprobaciones
		System.out.println(tarea3.containsTask(tarea4)); //True
		System.out.println(tarea5.containsTask(tarea1)); //True
		System.out.println(tarea1.containsTask(tarea5)); //false
		
		//Imprimimos cada tarea
		for (Task t :Tasks.getInstance().getTasksSet()){
			System.out.println(t);
		}
		
		//Eliminamos un par de tareas de la lista
		System.out.println(tarea3.removeTask(tarea2));//true
		System.out.println(tarea3.removeTask(tarea5));//false
		
		//Imprimimos cada tarea (ver que los valores cambian debido a la eliminacion de la tarea 4)
		for (Task t :Tasks.getInstance().getTasksSet()){
			System.out.println(t);
		}
		
		System.out.println();
		//Imprimimos cada tarea que todavía tiene un padre
		for (Task t :Tasks.getInstance().getTasksSet()){
			for (Task a: t.getTasks()){
				System.out.println(a);
			}
		}
		
		
	}
	

}
