package console;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase que implementa la consola.
 * @author Alejandro Sanchez Sanz alejandro.sanchezsanz@estudiante.uam.es
 *         Ricardo Riol Gonzalez ricardo.riol@estudiante.uam.es 
 *
 */
public class TextConsole extends Console {
	// Atributos
	private Map<String, Function> comandos;
	
	// Metodos
	public TextConsole() {
		this.comandos = new TreeMap<>();
		this.addCommands("start", super::start);
		this.addCommands("stop", super::stop);
		this.addCommands("addEstimate", super::addEstimate);
		this.addCommands("spend", super::spend);
		this.addCommands("parent", super::parent);
		this.addCommands("list", super::list);
		this.addCommands("status", super::status);
	}
	
	/**
	 * Metodo que nos permite simular el comportamieno de una terminal con una serie de comandos predefinidos
	 * @throws IOException Excepcion de entrada salida
	 */
	public void run() throws IOException {
		BufferedReader buffer = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		String linea;
		while (!((linea = buffer.readLine()).equals(""))) {
			String comando;
			int sgteBlanco = linea.indexOf(" ");
			try {
				if (sgteBlanco != -1) {
					comando = linea.substring(0, sgteBlanco);
					linea = linea.substring(sgteBlanco).trim();
					if (this.comandos.containsKey(comando)) {
						String argumentos[] = linea.split("\\s");
						this.comandos.get(comando).execute(argumentos);
					} else {
						System.out.println(this.comandos.keySet());
						System.out.flush();
					}
				} else {
					comando = linea;
					if (this.comandos.containsKey(comando)) {
						this.comandos.get(comando).execute();
					} else {
						System.out.println(this.comandos.keySet());
						System.out.flush();
					}
				}
			}  catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		}
		
		buffer.close();
	}
	
	/**
	 * Metodo que nos permite anadir comandos al conjuntos de comandos a manejar
	 * @param name Nombre del comando (es lo que deberemos introducir para que este sea ejecutado).
	 * @param op Operacion asociada al comando
	 */
	public void addCommands(String name, Function op) {
		this.comandos.put(name, op);
	}
	
	/**
	 * Main que nos permite probar la funcionalidad de la terminal y sus comandos
	 * @param args (No argumentos)
	 * @throws IOException Excepcion de entrada salida
	 */
	public static void main(String[] args) throws IOException {
		TextConsole consola = new TextConsole();
		consola.run();
	}
}
