

public class Node<T> implements Iterable<T>{
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
	

	public java.util.Iterator<T> iterator(){
     
          class NodeIterator<T> implements java.util.Iterator<T> {
               private Node<T> node;
                NodeIterator(Node<T> node){
                    this.node = node;
               }

                public T next() {
                	T result = node.getElement();
                	node = node.getNext();
                	return result;
            	}

                public boolean hasNext(){
                	return node != null;
                }

                public void remove(){
                	throw new UnsupportedOperationException();
                }
          } 
          return new NodeIterator<T>(this);
	}
}

