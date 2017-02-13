/**
* Esta aplicacion calcula el Triangulo de Tartaglia de dimension el parametro de entrada.
*
* @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
*		  Ricardo Riol ricardo.riol@estudiante.uam.es
*
*/
public class Tartaglia {

	/**
	* Punto de entrada a la aplicacion.
	*
	* Este metodo imprime el Triangulo de Tartaglia de dimension el numero que se le pasa como entrada.
	*
	* @param args Los argumentos de la linea de comando. Se espera un numero como primer parametro.
	*/
	public static void main (String [] args) {
		if(args.length < 1){
			System.out.println("Se espera un numero como parametro");
			return;
		}
		
		String arg = args[0];	// Una variable String que contiene el primer parametro
		int dimension = Integer.parseInt(arg);	// Una variable int, que convierte arg a numerico
		int [][] triangulo = new int [dimension+1][];	// Reservamos memoria para las columnas del triangulo
		int i, j;	// Contadores para los bucles
		for (i=0; i<=dimension; i++) {
			triangulo[i] = new int [i+1];	// Reservamos memoria para cada fila del triangulo
			for (j=0; j<i+1; j++) {
				if (j==0 || j==i) {
					triangulo[i][j] = 1;	// Los extremos son siempre 1
				} else {
					triangulo[i][j] = triangulo[i-1][j]+triangulo[i-1][j-1];	// Calculamos cada elemento
				}
			}
		}

		for (i=0; i<=dimension; i++) {
			for (j=0; j<i+1; j++) {
				System.out.print(triangulo[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
