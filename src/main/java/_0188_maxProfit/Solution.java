package _0188_maxProfit;

/**
 * @author hzdmm123
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }

        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }
        int[][] dp = new int[k][2];

        //dp i j i代表第几次交易   j 0 1 表示当前状态是买入 还是卖出
        // dp[i][j] 表示手里的钱
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            dp[0][0] = Math.max(dp[0][0], 0 - price);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + price);

            for (int i = 1; i < k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - price);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }
        return dp[k - 1][1];
    }


    // 解决无限次交易的方法
    public int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
