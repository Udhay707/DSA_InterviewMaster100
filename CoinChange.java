import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount, Map<Integer, Integer> memoize) {
        if(memoize.containsKey(amount))
            return memoize.get(amount);
        if(amount == 0)
            return 0;
        if(amount < 0)
            return -1;
        int min = -1;
        for(int i=0; i<coins.length; i++){
            int remainder = amount - coins[i];
            int result = coinChange(coins, remainder, memoize);
            if(result != -1){
                result = result + 1;
                min = min == -1 ? result : Math.min(min, result);
            }   
        }
        memoize.put(amount, min);
        return min;  
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int coins[] = {1,2,5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, amount, new HashMap<>()));
        System.out.println(coinChange.coinChange(new int[]{186,419,83,408}, 6249, new HashMap<>()));
        System.out.println(coinChange.coinChange(new int[]{1}, 0, new HashMap<>()));

    }
}
