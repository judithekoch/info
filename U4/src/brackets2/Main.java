package brackets2;

public class Main {

	public static void main(String[] args) {
		Brackets b = new Brackets("( ( ( ) ) )");
		System.out.println(b.checkBrackets());
		
		System.out.println("break");
		
		Brackets b2 = new Brackets("( ( )");
		System.out.println(b2.checkBrackets());

		System.out.println("break");
		
		Brackets b3 = new Brackets(") ( ( )");
		System.out.println(b3.checkBrackets());
		

	}

}
