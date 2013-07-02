package coinCombos;

import listStackChainNode.*;

public class Main {
	
	public static void main(String[] args) {

		Chain<Integer> coins = new Chain<Integer>(new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(5, new Node<Integer>(10, new Node<Integer>(20, null))))));
		
		CoinCombos coinCombo = new CoinCombos();
		System.out.println(coinCombo.coinCombo(4, coins));
		System.out.println(coinCombo.coinCombo(7, coins));
		System.out.println(coinCombo.coinCombo(22, coins));
		System.out.println(coinCombo.coinCombo(140, coins));
	}

}
