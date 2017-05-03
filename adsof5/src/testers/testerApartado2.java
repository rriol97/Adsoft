package testers;

import tasks.Task;
import tasks.Tasks;

public class testerApartado2 {

	public static void main(String[] args) {
		
		//Creamos tareas para poder "jugar" con ellas
		Task tarea1 = Tasks.getInstance().newTask("Practica ADSOFT",100);
		Task tarea2 = Tasks.getInstance().newTask("Practica PADSOFT",60);
		Task tarea3 = Tasks.getInstance().newTask("Examen SOPER",200);
		Task tarea4 = Tasks.getInstance().newTask("Examen LAB",1000);
		Task tarea5 = Tasks.getInstance().newTask("Examen CN",2);
		
		//Creamos la estructura del �rbol
		tarea5.addTask(tarea3);
		tarea3.addTask(tarea4);
		tarea3.addTask(tarea2);
		tarea2.addTask(tarea1);
		
		//Realizamos algunas comprobaciones
		System.out.println(tarea3.containsTask(tarea4)); //True
		System.out.println(tarea5.containsTask(tarea1)); //True
		System.out.println(tarea1.containsTask(tarea5)); //false
		
		//Imprimimos el valor estimado de cada tarea
		for (Task t :Tasks.getInstance().getTasksSet()){
			System.out.println(t);
		}
		
		//Eliminamos un par de tareas de la lista
		System.out.println(tarea3.removeTask(tarea4));//true
		System.out.println(tarea3.removeTask(tarea5));//false
		
		//Imprimimos el valor estimado de cada tarea (ver que los valores cambiab debido a la eliminacion de la tarea 4)
		for (Task t :Tasks.getInstance().getTasksSet()){
			System.out.println(t);
		}
		
		System.out.println();
		//Imprimimos el valor estimado de cada tarea no elimanada
		for (Task t :Tasks.getInstance().getTasksSet()){
			for (Task a: t.getTasks()){
				System.out.println(a);
			}
		}
		
		
	}
	

}