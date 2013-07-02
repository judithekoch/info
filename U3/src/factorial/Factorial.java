package factorial;
import java.util.*;

public class Factorial {
	
	List<Integer> list = new ArrayList<Integer>();
	
	Factorial(){
		int result = 1;
		for (int i = 0; i<= 100; i++){
			if (i == 0){
			} else {
				result *= i;
			}
		list.add(result);
		}
	}

	public int factorial_iterative(int n){
		int result = 1;
		for (int i = 1; i<=n; i++){
			result *= i;
		}
		return result;
	}
	
	public int fakultaet_recursive(int n) {
	     if (n>0) {
	          return n * fakultaet_recursive(n-1); // (direkte) Rekursion
	     } else {
	          return 1;
	     }
	}
	
	public int fakultaet_o1(int n){
		return list.get(n);
	}

	
}
