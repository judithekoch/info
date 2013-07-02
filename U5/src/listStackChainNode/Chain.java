package listStackChainNode;

import java.util.Iterator;

public class Chain<T> implements List<T>{
    private Node<T> first; //end of chain

    //empty chain
    public Chain(){
    first = null;
    }

    //Chain with existing list of nodes
    public Chain(Node<T> list){
         first = list;
    }
    
    public boolean isEmpty(){
    	if(first == null){
    		return true;
    	} else {
    		return false;
    	}
    }

    public T getElement(){
         return first.getElement();
    }
    
    public Chain<T> getNext(){
    	Chain<T> newChain = new Chain<T>(first.getNext());
        return newChain;
    }	

    public int getLength(){
         return first == null ? 0 : first.getLength();
    }
    
    public void insert(T value, int position){
    	Node<T> nodeBefore = first;
    	if(position==0){
    		Node<T> newFirst = new Node<T>(value, first); 
    		first = newFirst;
    	} else {
    		for(int i = 1; i<position; i++){
    			nodeBefore = nodeBefore.getNext(); 
    		}
    		Node<T> nodeAfter = nodeBefore.getNext();
    		nodeBefore.setNext(new Node<T>(value, nodeAfter));
    	}
    }
    
    public void remove(int position){
    	Node<T> nodeToRemove = first;
    	Node<T> nodeBefore = nodeToRemove;
    	if(position == 0){
    		first = first.getNext();
    	} else {
    		for(int i = 1; i<position; i++){
    			nodeBefore = nodeToRemove;
    			nodeToRemove = nodeToRemove.getNext(); 
    		}
    		if(nodeToRemove.getNext() == null){
    			nodeBefore.setNext(null);
    		} else {
    			nodeBefore.setNext(nodeToRemove.getNext());
    		}
    	}
    }

	@Override
	public Iterator<T> iterator() {
			return first.iterator();
	}
}

