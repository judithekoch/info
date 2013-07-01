
public class Testiditest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyScanner scanner = new MyScanner("(3+5)*(2+1)");
		MyParser parser = new MyParser(scanner);
		parser.parse();
		String bob = parser.stringPostOrder(parser.getParentNode());
		System.out.println("String = " + bob);
		
		Calculator tom = new Calculator(bob);
		System.out.println("Result: " + tom.getResult());
		

	}
	
	static boolean isInteger(int bob){
		return true;
	}

}
