

public class KnotenStapel<T>{

	private Knoten<T> ks = null; //leerer top-of-stack-Knoten
	
	/**
	 * Legt einen neuen  Knoten mit der Referenz auf den alten an
	 * @param neu: Element des neuen Knotens
	 */
	public void push(T neu){
		ks = new Knoten<T>(neu,ks);
	}

	/**
	 * Gibt das Element des obersten Knotens wieder und entfernt ihn
	 * @return Element des entfernten Knotens
	 */
	public T pop(){
		T head = ks.head();
		ks = ks.tail();
		return head;
	}

	/**
	 * @return Element des obersten Knotens
	 */
	public T top() {
		return ks.head();
	}

	/**
	 * @return boolean ob der Stack leer ist
	 */
	public boolean isEmpty() {
		return ks == null;
	}

	/**
	 * leert den ganzen Stack
	 */
	public void makeEmpty() {
		ks = null;	//Löscht das oberste Element und somit auch die Referenzen auf die folgenden
	}
	
	/**
	 * Ausgabe aller Elemente der Knoten zur Überprüfung
	 */
	public void ausgeben() {
		Knoten<T> current = ks;
		if(isEmpty()){	//wenn der Stack leer ist
			System.out.println("Stack ist leer");
		}
		else{
			for(int i=0; i<ks.länge(); i++){ //Gibt das Element aus und iteriert weiter
				System.out.println(current.head());
				current = current.tail();
			}
		}
	}
	
	
}
