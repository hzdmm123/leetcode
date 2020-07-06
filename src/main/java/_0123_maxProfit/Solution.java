package _0123_maxProfit;

/**
 * @author hzdmm123
 */
public class Solution {
    public int maxProfit(int[] prices) {

        int min_priceOne = Integer.MAX_VALUE;
        int max_profitOne = 0;
        int maxProfitAfterBuy = Integer.MIN_VALUE;
        int max_profitTwo = 0;

        for (int price : prices) {
            min_priceOne = Math.min(min_priceOne, price);
            max_profitOne = Math.max(max_profitOne, price - min_priceOne);

            maxProfitAfterBuy = Math.max(maxProfitAfterBuy, max_profitOne - price);
            max_profitTwo = Math.max(max_profitTwo, price + maxProfitAfterBuy);
        }

        return max_profitTwo;
    }
}
