package listStackChainNode;

import java.util.*;

public class Brackets {

	private Scanner scanner;

	public void checkBrackets(){
		NodeStack<String> nodeStack = new NodeStack<String>();
		scanner = new Scanner(System.in);
		System.out.print("Input: ");
		String string = scanner.next();
		StringTokenizer st = new StringTokenizer(string);	
		
		while(st.hasMoreTokens()){
			String nextString = st.nextToken();
			System.out.println(nextString);
			if(nextString.equals("(") || nextString.equals("[") || nextString.equals("{")){
				nodeStack.push(nextString);
			} else if(nextString.equals(")") || nextString.equals("]") || nextString.equals("}")){
				if(nodeStack.isEmpty()){
					System.out.println("There was a mistake in the line of brackets - no opening bracket");
				} else if(nodeStack.top().equals("(") && nextString.equals(")")) {
					nodeStack.pop();
				} else if(nodeStack.top().equals("[") && nextString.equals("]")) {
					nodeStack.pop();
				} else if(nodeStack.top().equals("{") && nextString.equals("}")) {
					nodeStack.pop();
				} else {
					System.out.println("There was a mistake in the line of brackets - brackets not matching");
				}
			}	
		}
		
		if(!nodeStack.isEmpty()){
			System.out.println("There was a mistake in the line of brackets - stack is not empty");
		}
	}
}
