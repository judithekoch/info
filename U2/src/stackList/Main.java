package stackList;

public class Main {

	public static void main(String[] args) {
		Node n = new Node(6, null);
		Node n1 = new Node(2, n);
		Node n2 = new Node(8, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(4, n3);
		Node n5 = new Node(5, n4);
		Node n6 = new Node(7, n5);
   	 System.out.println(n6.getLength());//
   	 System.out.println(n.getElement());//
   	 System.out.println(n4.getTail().elementData);//
   	 
   	 
   	 Stack s = new Stack();
   	 System.out.println(s.isEmpty());//
   	 s.push(4);//
   	 System.out.println(s.root.elementData);
   	 s.push(7);//
   	 System.out.println(s.getLatest().elementData);
   	 
   	 s.pop();
   	 System.out.println(s.isEmpty());
   	 s.pop();
   	 System.out.println(s.isEmpty());
		
		Brackets b = new Brackets();
		b.checkBrackets();
	}

}
