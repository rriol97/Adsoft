package console;

@FunctionalInterface
public interface Function {
	/**
	 * 
	 * @param args argumentos de entrada de los comandos (tamano variable)
	 * @throws IllegalArgumentException Argumentos de entrada erroneos
	 */
	void execute(String ...args) throws IllegalArgumentException;
}
