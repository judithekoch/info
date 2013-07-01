import java.util.StringTokenizer;



public class Calculator {
	
	String term;
	int result;
	
	KnotenStapel<Integer> calc = new KnotenStapel<>();

	public Calculator(String term){
		this.term = term;
		char[] termArray = term.toCharArray();
		pushOnStack(termArray);
		result = calc.top();
	}
	
	public void pushOnStack(char[] termArray){
		for(int i=0; i<termArray.length; i++){
			parse(termArray[i]);
		}
		
	}

	public void parse(Character token){
		if(token == '+'){
			int first = calc.pop();
			int second = calc.pop();
			
			calc.push(first + second);
		}
		else if(token == '-'){
			int second = calc.pop();
			int first = calc.pop();
			
			calc.push(first - second);
		}
		else if(token == '*'){
			int second = calc.pop();
			int first = calc.pop();
			
			calc.push(first * second);
		}
		else{
			calc.push(Character.getNumericValue(token));
		}
	}
	
	public int getResult(){
		return result;
	}
}
