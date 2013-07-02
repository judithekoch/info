package listStackChainNode;

import stackList.Brackets;

public class Main {

	public static void main(String args[]){
	    /*Node<Integer> n0 = new Node<Integer>(5, null);
	    Node<Integer> n1 = new Node<Integer>(3, n0);		
		
		Node<Integer> n2 = new Node<Integer>(7, n1);
		Node<Integer> n3 = new Node<Integer>(8, n2);

		Chain<Integer> c1 = new Chain<Integer>(n3);
		
		System.out.println("Length of c1: " + c1.getLength());
		System.out.println("Last element of c1: " + c1.getElement());
		System.out.println("Last but one element of c1: " + c1.getNext().getElement());
		System.out.println("Last but one length of c1: " + c1.getNext().getLength());
		
		c1.insert(15, 0);
		c1.insert(16, 0);
		c1.insert(17, 0);
		c1.insert(18, 0);
		c1.insert(19, 0);
		System.out.println("New length of c1: " + c1.getLength());
		c1.insert(22, 3);
		System.out.println("New length of c1: " + c1.getLength());
		
		c1.remove(0);
		System.out.println("New length of c1: " + c1.getLength());
		c1.remove(5);
		System.out.println("New length of c1: " + c1.getLength());

	     Node<String> nsI = new Node<String>("Hallo", new Node<String>("du", new Node<String>("da", null)));
	     Node<String> nsII = nsI.getNext();
		
	     System.out.println(nsII.getElement());
	     
	     
	     NodeStack<String> nodeStack = new NodeStack<String>();
	     System.out.println(nodeStack.isEmpty());
	     nodeStack.push("Hallo ");
	     nodeStack.push("du ");
	     nodeStack.push("da ");
	     System.out.println(nodeStack.isEmpty());
	     System.out.println(nodeStack.top());
	     nodeStack.pop();
	     System.out.println(nodeStack.top());
	     nodeStack.pop();
	     nodeStack.pop();
	     System.out.println(nodeStack.isEmpty());*/
		
		Brackets b = new Brackets();
		b.checkBrackets();
	}

}
