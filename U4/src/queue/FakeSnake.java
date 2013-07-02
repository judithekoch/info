package queue;

import listStackChainNode.*;

public class FakeSnake<T> implements Stack<T>{
	
	private QueueNode<T> first = null;
	private QueueNode<T> last = null;
	
	//Konstruktor mit nur einem Element
	public FakeSnake(QueueNode<T> first){
		this.first = first;
		this.last = first;
	}
	
	//Konstruktor mit mehr als einem Element
	public FakeSnake(QueueNode<T> first, QueueNode<T> last){
		this.first = first;
		this.last = last;
	}
	
	@Override
	public void push(T newStack){
		first = new QueueNode<T>(newStack, first); 
	}
	
	@Override
    public T pop(){
    	if (!isEmpty()){
    	QueueNode<T> lastOutput = last;
    	if (last.hasNext()){
    	last = last.getNext();
    	} else {
    		last = null;
    		first = null;
    	}
    	return lastOutput.getElement();
    	} else {
    		return null;
    	}
    }
    
	@Override
    public T top(){
    	if (!isEmpty()){
    	return last.getElement();
    	} else {
    		return null;
    	}
    }

	@Override
    public Boolean isEmpty(){
    	if (first == null){
    		return true;
    	} else {
    		return false;
    	}
    }

}
