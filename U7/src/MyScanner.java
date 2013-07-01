import java.util.*;

public class MyScanner {

	private String stringToScan;
	public char[] charArray;
	public ArrayList<Character> charArrayList = new ArrayList<Character>(); 
	public Character[] charArrayToUse;
	private Brackets brackets;
	private boolean correctBrackets;
	
	public MyScanner(String string){
		stringToScan = string;
		brackets = new Brackets(string);
		correctBrackets = (brackets.pruefeKlammerung()) ? true : false;
	}
	
	public void scan(){
		if (!correctBrackets){
			System.out.println("Please check your brackets, you might not get the desired result.");
		}
		charArray = stringToScan.toCharArray();
		makeArrayList(charArray);
		if (!checkForBrackets()){
			insertBrackets(charArrayList);
		}
		
		charArrayToUse = new Character[charArrayList.size()];
		
		charArrayList.toArray(charArrayToUse);
	}
	
	private void insertBrackets(ArrayList<Character> charArrayList){
		for (int i = 0; i < charArrayList.size(); i++){
			if(charArrayList.get(i) == '*'){
				charArrayList.add(i-1, '(');
				charArrayList.add(i+3, ')');
				i++;
			}
		}
	}
	
	private boolean checkForBrackets(){
		boolean brackets = false;
		test:
			for(Character c : charArrayList){
				brackets = "({[]})".indexOf(c) >= 0;
				if(brackets) {
					break test;
				}
			} 
		return brackets;
	}
	
	private void makeArrayList(char[] charArray){
		for (int i = 0; i < charArray.length; i++){
			charArrayList.add((Character)charArray[i]);
		}
	}
	
	public Character[] getCharArray(){
		return charArrayToUse;
	}
}
