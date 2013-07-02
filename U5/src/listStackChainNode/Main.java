package listStackChainNode;

import java.util.Iterator;


public class Main {

	public static void main(String args[]){
		Chain<String> chain = new Chain<String>();
		chain.insert("Hallo", 0);
		chain.insert("Welt", 1);
		chain.insert("!", 2);
		
		Iterator<String> iterator = chain.iterator(); 
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println(" ");
	
		Chain<Integer> emptyChain = new Chain<Integer>();
		try{		
		Iterator<Integer> emptyIterator = emptyChain.iterator();

			while(emptyIterator.hasNext()){
				System.out.println(emptyIterator.next());
			}
		}catch(NullPointerException exception){
			System.out.println("Your chain is empty!");
		}
	}

}
