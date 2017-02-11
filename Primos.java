
public class Primos {

	/**
	* Punto de entrada a la aplicacion.
	*
	* Este metodo calcula si un número de primos que se pasan como argumentos son primos.
	*
	*
	*@param args Los argumentos de la línea de comando.Se espera una lista de enteros. 
	*/

	public static Boolean esPrimo(int numero){
		
		Boolean bool = Boolean.TRUE;
		int contador = 2;

		if (numero < 2){
			return Boolean.FALSE;
		}		

		if (numero == 2){
			return Boolean.TRUE;
		}		

		while (contador < numero){

			if (numero % contador == 0){
				
				bool = Boolean.FALSE;


			}				
			contador ++;
		}	
			
		return bool;
	}

	public static void main(String [] args){
		Boolean bool;
		if (args.length < 1) {
			System.out.println("Se espera un numero como parametro");
			return;
		}

		for (String s: args) {
			int numero = Integer.parseInt(s);
			bool = esPrimo(numero);
			
			if (bool == Boolean.TRUE) {
				System.out.println("El numero "+numero+" SI es primo");
			}

			if (bool == Boolean.FALSE) {
				System.out.println("El numero "+numero+" NO es primo");
			}
		}
	}

}	

