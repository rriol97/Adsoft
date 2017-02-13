/**
* Esta aplicacion calcula cuales de los numeros que se pasan como parametro de entrada son primos o no.
*
* @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
*		  Ricardo Riol ricardo.riol@estudiante.uam.es
*
*/
public class Primos {

	/**
	* Este metodo calcula si el numero que se pasa como argumento de entrada es primo o no.
	*
	* @param numero El entero que se quiere evaluar si es primo o no. 
	*/
	public static boolean esPrimo(int numero){
		if (numero < 2) {
			return false;
		}		

		if (numero == 2) {
			return true;
		}		

		boolean bool = true; 
		int contador = 2;
		double raiz = Math.ceil(Math.sqrt(numero));	// Solo hace falta comprobar hasta la raiz redondeada del numero
		while (contador <= raiz){
			if (numero % contador == 0){
				bool = false;
			}				
			contador ++;
		}	
			
		return bool;
	}

	/**
	* Punto de entrada a la aplicacion.
	*
	* Este metodo calcula si el numero que se pasa como argumento de entrada es primo o no.
	*
	* @param args Los argumentos de la linea de comando. Se espera una lista de enteros. 
	*/
	public static void main(String [] args){
		if (args.length < 1) {
			System.out.println("Se espera un numero como parametro");
			return;
		}

		for (String s: args) {
			int numero = Integer.parseInt(s);	// Una variable int, que convierte cada elemento de args a numerico
			boolean bool = esPrimo(numero);		// Una variable boolean, que recibe si el numero es primo o no
			
			if (bool) {
				System.out.println("El numero "+numero+" SI es primo");
			} else {
				System.out.println("El numero "+numero+" NO es primo");
			}
		}
	}

}	

