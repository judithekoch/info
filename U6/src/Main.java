
public class Main {

	public static void main(String args[]){
		
		MyScanner scanner = new MyScanner("1*(3+5)-3*2");
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
		parser2.printTreePreOrder(parser2.getParentNode());
		System.out.println("");
		parser2.printTreeInOrder(parser2.getParentNode());
		System.out.println("");
		parser2.printTreePostOrder(parser2.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner3 = new MyScanner("x+y*3+7-2");
		MyParser parser3 = new MyParser(scanner3);
		parser3.parse();
		parser3.printTreePreOrder(parser3.getParentNode());
		System.out.println("");
		parser3.printTreeInOrder(parser3.getParentNode());
		System.out.println("");
		parser3.printTreePostOrder(parser3.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner4 = new MyScanner("x+y*(3+7-2)");
		MyParser parser4 = new MyParser(scanner4);
		parser4.parse();
		parser4.printTreePreOrder(parser4.getParentNode());
		System.out.println("");
		parser4.printTreeInOrder(parser4.getParentNode());
		System.out.println("");
		parser4.printTreePostOrder(parser4.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner5 = new MyScanner("2*(3+7)"); 
		MyParser parser5 = new MyParser(scanner5);
		parser5.parse();
		parser5.printTreePreOrder(parser5.getParentNode());
		System.out.println("");
		parser5.printTreeInOrder(parser5.getParentNode());
		System.out.println("");
		parser5.printTreePostOrder(parser5.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner6 = new MyScanner("(3+7)*2"); 
		MyParser parser6 = new MyParser(scanner6);
		parser6.parse();
		parser6.printTreePreOrder(parser6.getParentNode());
		System.out.println("");
		parser6.printTreeInOrder(parser6.getParentNode());
		System.out.println("");
		parser6.printTreePostOrder(parser6.getParentNode());
		
		System.out.println("\nnext:");
		MyScanner scanner7 = new MyScanner("(a+3)*(b-5*2)"); 
		MyParser parser7 = new MyParser(scanner7);
		parser7.parse();
		parser7.printTreePreOrder(parser7.getParentNode());
		System.out.println("");
		parser7.printTreeInOrder(parser7.getParentNode());
		System.out.println("");
		parser7.printTreePostOrder(parser7.getParentNode());
		
		System.out.println("\nnext: ERROR");
		MyScanner scanner8 = new MyScanner("(a+3*(b-5*2)"); 
		MyParser parser8 = new MyParser(scanner8);
		parser8.parse();
		parser8.printTreePreOrder(parser8.getParentNode());
		System.out.println("");
		parser8.printTreeInOrder(parser8.getParentNode());
		System.out.println("");
		parser8.printTreePostOrder(parser8.getParentNode());
	}
	
}
