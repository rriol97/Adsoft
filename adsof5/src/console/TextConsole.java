package console;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class TextConsole extends Console {
	// Atributos
	private Map<String, Function> comandos;
	
	// Metodos
	public TextConsole() {
		this.comandos = new TreeMap<>();
	}
	
	public void run() throws IOException {
		BufferedReader buffer = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		String linea;
		while ((linea = buffer.readLine()) != null) {
			int sgteBlanco = linea.indexOf(" ");
			String comando = linea.substring(0, sgteBlanco);
			linea = linea.substring(sgteBlanco).trim();
			
			if (this.comandos.containsKey(comando)) {
				String argumentos[] = linea.split("\\s+");
				this.comandos.get(comando).execute(argumentos);
			} else {
				System.out.println(this.comandos);
			}
		}
	}
	
	public void addCommands(String name, Function op) {
		this.comandos.put(name, op);
	}
}
