package stackList;

public class Stack {

	
	Node root;
	
	public Stack(){
	}
	
	public Stack(Integer i){
		push(i);
	}
	
    public void push(Integer i){
    	if(root==null){
    		root = new Node(i, null);
    	} else{
    	  Node last = getLatest();
    	  last.next = new Node(i, null);
    	}
    }
    
    public void push(String s){
    	if(root==null){
    		root = new Node(s, null);
    	} else{
    	  Node last = getLatest();
    	  last.next = new Node(s, null);
    	}
    }
     
     public Integer pop(){
    	 if(root==null){
    		 return null;
    	 } else if(root.next == null){
    		 Integer element = root.elementData;
    		 root = null;
    		 return element;
    	 } else {
    		 Node last = getLatest();
    		 Node lastButOne = root;
    		 Integer element = last.elementData;
    		 int numberElements = last.getLength();
    		 for(int i = 0; i<(numberElements); i++){
    			 lastButOne = lastButOne.next;
    		 }
    		 lastButOne.next = null;
    		 return element;
    	 }
     }
     
    
    
    public Node getLatest(){
    	Node last = root;
    	if(last != null){
    		boolean isLast = false;
    		while(!isLast){
    			if(last.next == null){
    				isLast=true;
 				} else {
    				last = last.next;
    			}
    		}
    	}
    	return last;
    	
    }
    
    public boolean isEmpty(){
    	boolean isEmpty;
    	if(root == null){
    		isEmpty = true;
    	} else {
    		isEmpty = false;
    	}
    	return isEmpty;
    }

}
