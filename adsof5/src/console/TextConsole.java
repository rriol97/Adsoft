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
		this.addCommands("start", super::start);
		this.addCommands("stop", super::stop);
		this.addCommands("addEstimate", super::addEstimate);
		this.addCommands("spend", super::spend);
		this.addCommands("parent", super::parent);
		this.addCommands("list", super::list);
		this.addCommands("status", super::status);
	}
	
	public void run() throws IOException {
		BufferedReader buffer = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		String linea;
		while ((linea = buffer.readLine()) != null) {
			String comando;
			int sgteBlanco = linea.indexOf(" ");
			if (sgteBlanco != -1) {
				comando = linea.substring(0, sgteBlanco);
				linea = linea.substring(sgteBlanco).trim();
				if (this.comandos.containsKey(comando)) {
					String argumentos[] = linea.split("\\s");
					this.comandos.get(comando).execute(argumentos);
				} else {
					System.out.println(this.comandos);
				}
			} else {
				comando = linea;
				if (this.comandos.containsKey(comando)) {
					this.comandos.get(comando).execute();
				} else {
					System.out.println(this.comandos);
				}
			}
			
		}
		
		buffer.close();
	}
	
	public void addCommands(String name, Function op) {
		this.comandos.put(name, op);
	}
	
	
	public static void main(String[] args) throws IOException {
		TextConsole consola = new TextConsole();
		consola.run();
	}
}
