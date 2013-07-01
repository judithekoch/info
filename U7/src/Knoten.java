

public class Knoten <T>{
	
	private T elem; // Element des Knotens
	private Knoten <T> nächster; // Referenz auf den nächsten Knoten
	
	/**
	 * Konstruktor
	 * @param neu: Element des Knotens
	 * @param rest: Referenz auf den nächsten
	 */
	public Knoten(T neu, Knoten <T> rest){
		elem = neu;
		nächster = rest;
	}
	
	/**
	 * @return Element des Knotens
	 */
	public T head(){
		return elem;
	}
	
	/**
	 * @return der folgende Knoten
	 */
	public Knoten <T> tail(){
		return nächster;
	}
	
	/** 
	 * @return Anzahl der Knoten
	 */
	public int länge(){
		return 1 + (nächster == null ? 0: nächster.länge());
	}

}
