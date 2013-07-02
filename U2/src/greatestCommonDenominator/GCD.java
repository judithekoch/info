package greatestCommonDenominator;

public class GCD {
	
	public int gcd(int a, int b){
		if (a > b){
			return calculateGcd(a,b);
		} else {
			return calculateGcd(b,a);
		}
	}
	
	private int calculateGcd(int c, int d){
		int result = 1;
		for (int i=1; i<=d; i++){
			if (c%i == 0 && d%i ==0){
				result = i;
			}
		}
		
		return result;
	}
}
