

public class Knoten <T>{
	
	private T elem; // Element des Knotens
	private Knoten <T> n�chster; // Referenz auf den n�chsten Knoten
	
	/**
	 * Konstruktor
	 * @param neu: Element des Knotens
	 * @param rest: Referenz auf den n�chsten
	 */
	public Knoten(T neu, Knoten <T> rest){
		elem = neu;
		n�chster = rest;
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
		return n�chster;
	}
	
	/** 
	 * @return Anzahl der Knoten
	 */
	public int l�nge(){
		return 1 + (n�chster == null ? 0: n�chster.l�nge());
	}

}
