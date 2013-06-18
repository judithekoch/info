import java.util.*;

public class MyScanner {

	private String stringToScan;
	public char[] charArray;
	
	public MyScanner(String string){
		stringToScan = string;
	}
	
	public void scan(){
		charArray = stringToScan.toCharArray();
		/*for (String string : charArray){
			System.out.print(string);
		}*/
	}
	
	public char[] getCharArray(){
		return charArray;
	}
}
