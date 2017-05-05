package console;


/**
 * Interfaz que define el comportamiento de cualquier comando de la consola.
 * 
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
@FunctionalInterface
public interface Function {
	/**
	 * 
	 * @param args argumentos de entrada de los comandos (tamano variable)
	 * @throws IllegalArgumentException Argumentos de entrada erroneos
	 */
	void execute(String ...args) throws IllegalArgumentException;
}
