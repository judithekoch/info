package stackList;

import java.util.*;

public class Brackets {

	private Scanner scanner;

	public void checkBrackets(){
		Stack stack = new Stack();
		scanner = new Scanner(System.in);
		System.out.print("Input: ");
		String string = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(string);
		
		while(st.hasMoreTokens()){
			String nextString = st.nextToken();
			if(nextString.contentEquals("(") || nextString.contentEquals("[") || nextString.contentEquals("{")){
				stack.push(nextString);
			} else if(nextString.contentEquals(")") || nextString.contentEquals("]") || nextString.contentEquals("}")){
				if(stack.isEmpty()){
					System.out.println("There was a mistake in the line of brackets - no opening bracket");
				} else if(stack.getLatest().elementString.contentEquals("(") && nextString.contentEquals(")")) {
					stack.pop();
				} else if(stack.getLatest().elementString.contentEquals("[") && nextString.contentEquals("]")) {
					stack.pop();
				} else if(stack.getLatest().elementString.contentEquals("{") && nextString.contentEquals("}")) {
					stack.pop();
				} else {
					System.out.println("There was a mistake in the line of brackets - brackets not matching");
				}
			}	
		}
		
		if(!stack.isEmpty()){
			System.out.println("There was a mistake in the line of brackets - stack is not empty");
		}
	}
}
