package listStackChainNode;

public class NodeStack<T> implements Stack<T>{
    private Node<T> ns = null;


    @Override
    public void push(T t){
         ns = new Node<T>(t, ns);
    }

    @Override
    public T pop(){
         T element = ns.getElement();
         if(ns.getNext() != null){
         ns = ns.getNext();
         } else {
        	 ns = null;
         }
         return element;
    }
    
    @Override
    public T top(){
    	return ns.getElement();
    }
    
    @Override
    public Boolean isEmpty(){
    	if(ns == null){
    		return true;
    	} else {
    		return false;
    	}
    }
}
