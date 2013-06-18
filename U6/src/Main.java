
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
		
		System.out.println("\nnext:");
		parser.printTreePreOrder(parser2.getParentNode());
		System.out.println("");
		parser.printTreeInOrder(parser2.getParentNode());
		System.out.println("");
		parser.printTreePostOrder(parser2.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner3 = new MyScanner("x+y*3+7-2");
		MyParser parser3 = new MyParser(scanner3);
		parser3.parse();
		parser.printTreePreOrder(parser3.getParentNode());
		System.out.println("");
		parser.printTreeInOrder(parser3.getParentNode());
		System.out.println("");
		parser.printTreePostOrder(parser3.getParentNode());
	}
	
}
