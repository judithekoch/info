package coins;

import java.util.ArrayList;
import java.util.List;

public class Coins {

	List<Integer> list = new ArrayList<Integer>();
	
	Coins(){
		
		list.add(001);
		list.add(002);
		list.add(005);
		list.add(010);
		list.add(020);
		list.add(050);
		list.add(100);
		list.add(200);
		
	}
	
	public int numberOfPossibilities(int n){
		if (n-50 <= 0){
			return 0;
		} else {
			return n/2 + 1 + nop5(n-5) + nop10(n-10) + nop20(n-20) + nop50(n-50); 
		}
	}
	
	// Jonas
	
	private int nop5(int n){
		if (n-5 <= 0){
			return 0;
		} else {
		return n/2 + 1 + nop5(n-5);
		}
	}
	private int nop10(int n){
		if (n-10 <= 0){
			return 0;
		} else {
		return n/2 + 1 + nop5(n-5) + nop10(n-10);
		}
	}
	private int nop20(int n){
		if (n-20 <= 0){
			return 0;
		} else {
		return n/2 + 1 + nop5(n-5) + nop10(n-10) + nop20(n-20);
		}
	}
	private int nop50(int n){
		if (n-50 <= 0){
			return 0;
		} else {
		return n/2 + 1 + nop5(n-5) + nop10(n-10) + nop20(n-20) + nop50(n-50);
		}
	}
		
		/* JonasAbwandlung
		 
		int result = 0;
		for (int i = list.size()-1; i >=0; i--){
		if (n-list.get(i)<=0){
			result += 0;
		} else {
			result = numberOfPossibilities(n-list.get(i)) + 1;
		}
		}
		
		return result;
		*/
			
		/* ???
		  
		int result = 0;
				
		for (int i = 7; i >= 0; i--){
			if (n%list.get(i)==0){
				result++;
			} else {
				int rest = n-n/i;
				result++;
				for(int j = i-1; j>=0; j--){
					if (rest%list.get(j)==0){
						result++;
					} else {
						rest = rest - rest/j;
						result++;
						for(int k = j-1; k>=0; k--){
							if (rest%list.get(k)==0){
								result++;
							} else {
								rest = rest - rest/k;
								result++;
								for(int l = k-1; l>=0; l--){
									if (rest%list.get(l)==0){
										result++;
									} else {
										rest = rest - rest/k;
										result++;
										for(int m = l-1; m>=0; m--){
											if (rest%list.get(m)==0){
												result++;
											} else {
												rest = rest - rest/m;
												result++;
												for(int q = m-1; q>=0; q--){
													if (rest%list.get(q)==0){
														result++;
													} else {
														rest = rest - rest/q;
														result++;
														for(int o = m-1; o>=0; o--){
															if (rest%list.get(o)==0){
																result++;
															} else {
																rest = rest - rest/o;
																result++;
																for(int p = o-1; p>=0; p--){
																	if (rest%list.get(p)==0){
																		result++;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
		}
		
		
		
		return result;
		}
		*/
		
	
}
