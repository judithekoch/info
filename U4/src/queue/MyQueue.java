package queue;

public class MyQueue<T> implements Queue<T>{

	private QueueNode<T> first = null;
	private QueueNode<T> last = null;
	
	//Konstruktor mit nur einem Element
	public MyQueue(QueueNode<T> queueNode){
		first = queueNode;
		last = queueNode;
	}
	
	//Konstruktor mit mehr als einem Element
	public MyQueue(QueueNode<T> firstQueueNode, QueueNode<T> lastQueueNode){
		first = firstQueueNode;
		last = lastQueueNode;
	}
	
	@Override
	public void enqueue(T element) {
		if (!isEmpty()){
		last.setNext(new QueueNode<T>(element, null));
		last = last.getNext();
		} else {
			first = new QueueNode<T>(element, null);
			last = first;
		}
	}

	@Override
	public void dequeue() {
		if (first.hasNext()){
			first = first.getNext();
		} else {
			first = null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (first == null)
			return true;
		else
			return false;
	}
	
	public T getFirst(){
		if(first == null){
			return null;
		} else {
			return first.getElement();	
		}
	}
	
	public T getLast(){
		if(last == null){
			return null;
		} else {
			return last.getElement();
		}
	}
	
	public void cancelLast(){
		if(first.getNext() == last){
			last = null;
			first.setNext(null);
		} else if (first.hasNext()){
			last = getLastButOne();
			last.setNext(null);
		} else {
			first = null;
		}
	}
	
	private QueueNode<T> getLastButOne(){
		QueueNode<T> lastButOne = first;
		QueueNode<T> lastOne = first;
		QueueNode<T> lastOneOld = first;
		while(lastOne.hasNext()){
			lastOneOld = lastOne;
			lastOne = lastButOne.getNext();
			lastButOne = lastOneOld;
		}
		
		return lastButOne;
	}

}
