
public class Main {

	public static void main(String args[]){
		
		MyScanner scanner = new MyScanner("(1*3)+(5-(3*2))");
		MyParser parser = new MyParser(scanner);
		parser.parse();
		
		parser.printTreePreOrder(parser.getParentNode());
		System.out.println("");
		parser.printTreeInOrder(parser.getParentNode());
		System.out.println("");
		parser.printTreePostOrder(parser.getParentNode());
		
		MyScanner scanner2 = new MyScanner("((x+y)*(3+(7-2)))");
		MyParser parser2 = new MyParser(scanner2);
		parser2.parse();
		
		System.out.println("next:");
		parser.printTreePreOrder(parser.getParentNode());
		System.out.println("");
		parser.printTreeInOrder(parser.getParentNode());
		System.out.println("");
		parser.printTreePostOrder(parser.getParentNode());
		
	}
	
}
