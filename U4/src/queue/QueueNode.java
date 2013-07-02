package queue;

public class QueueNode<T> {
	private QueueNode<T> next = null;
	private T element = null;
	
	public QueueNode(T element, QueueNode<T> next){
		this.element = element;
		this.next = next;
	}
	
	public QueueNode<T> getNext(){
		return next;
	}
	
	public void setNext(QueueNode<T> next){
		this.next = next;
	}
	
	public T getElement(){
		return element;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public boolean hasNext(){
		if (next != null){
			return true;
		} else {
			return false;
		}
	}
}
