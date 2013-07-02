package brackets2;

import java.util.StringTokenizer;
import queue.*;

public class Brackets {
	
	StringTokenizer st;
	MyQueue<String> queue = new MyQueue<String>(null);
	
	public Brackets(String string){
		st = new StringTokenizer(string);
		while(st.hasMoreTokens()){
			queue.enqueue(st.nextToken());
		}
	}
	
	public boolean checkBrackets(){		
		if(queue.getFirst() != null && queue.getFirst().contentEquals("(")){
			queue.dequeue();
			if(queue.getLast() != null && queue.getLast().contentEquals(")")){
				queue.cancelLast();
				return checkBrackets();
			} else {
				return false;
			}
		} else if (queue.isEmpty()){
			return true;
		} else {
		return false;
		}
	}
}
