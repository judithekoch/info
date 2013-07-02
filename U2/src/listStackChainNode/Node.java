package listStackChainNode;

public class Node<T>{
	private T element;
	private Node<T> next;

	
	public Node(T element,  Node<T> next){
			this.element = element;
			this.next = next;
	}

	
	public T getElement(){ //head()
		return element;
	} 

	public Node<T> getNext(){ //tail()
		return next;
	}
	
	public void setNext(Node<T> next){
		this.next = next;
	}

	public int getLength(){
		return 1 + (next == null ? 0 : next.getLength());
    }
}

