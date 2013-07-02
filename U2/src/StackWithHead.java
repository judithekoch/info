

import stackList.Node;

public class Stack {

	
	Node root;
	
    public void push(Integer i){
    	if(root==null){
    		root = new Node(null, i, null);    		
    	} else if (root.head != null) {
    		/*Node n = new Node(null, i, root);
    		root.head = n;*/
    		root.head = new Node(null, i, root);
    	} else {
    		/*Node nO = root.head;
    		Node n1 = new Node(n0, i, root);
    		root.head = n1;
    		n0.tail = n1*/
    		root.head.next = new Node(root.head, i, root);
    		root.head = root.head.next;
    	}
    	/* Ueber Sammlung iterieren
    	 * Node last = root;
    	 * isLast = false;
    	 * while(!isLast){
    	 * if(last.next == null){
    	 * isLast=true;
    	 * } else {
    	 * last = last.tail;
    	 * }
    	 * }
    	 */
    }
     
     /*Integer pop();
     //throws UnderflowException;
     boolean isEmpty();
     // Integer top(); //gibt oberstes Element an*/

}
