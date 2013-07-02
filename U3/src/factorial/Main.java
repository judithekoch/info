package factorial;

public class Main {

	public static void main(String[] args) {
		Factorial fakultaet = new Factorial();
		System.out.println(fakultaet.fakultaet_recursive(13));

		System.out.println(fakultaet.fakultaet_o1(13));
	}

}
