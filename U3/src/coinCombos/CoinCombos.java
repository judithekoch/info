package coinCombos;

import listStackChainNode.*;

public class CoinCombos {


int coinCombo(int x, Chain<Integer> coins){ 
     if (x<0) return 0;
     else if (x==0) return 1;
     else if ((coins).isEmpty()) return 0;
     else { // Fallunterscheigung: 1. MŸnzwert verwenden oder nicht
          return coinCombo(x-coins.getElement(), coins)
               + coinCombo(x, coins.getNext());
     }
}


}
