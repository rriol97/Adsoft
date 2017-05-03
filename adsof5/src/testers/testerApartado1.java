package testers;

import observer.*;

public class testerApartado1 {

	public static void main(String[] args) {
		TimeProperty nodo1 = new TimeProperty ();
		TimeProperty nodo2 = new TimeProperty ();
		TimeProperty nodo3 = new TimeProperty ();
		TimeProperty nodo4 = new TimeProperty ();
		TimeProperty nodo5 = new TimeProperty ();

		//Inicializamos todos los valores a un valor cualquiera
		nodo1.setValue(3);
		nodo2.setValue(6);
		nodo3.setValue(2);
		nodo4.setValue(8);
		nodo5.setValue(3);
		//Creamos la estructura para "jugar" con los valores
		nodo2.addProperty(nodo1);
		nodo3.addProperty(nodo1);
		nodo4.addProperty(nodo3);
		nodo2.addProperty(nodo5);
		
		//Comprobamos que el valor del nodo 2 es la suma del nodo 1 y el nodo 6
		Integer a = nodo1.getValue();
		Integer b = nodo5.getValue();
		System.out.println("Nodo 1: "+a+" Nodo 5: "+b+" resultado: "+nodo2.getValue());
		
		//Comprobamos que el valor de nodo 4 se ha incremetado correctamente
		System.out.println((nodo3.getValue() + 8 == nodo4.getValue())+" "+nodo4.getValue());

	}

}
