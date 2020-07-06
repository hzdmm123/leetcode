package _0198_robber;

/**
 * @author hzdmm123
 * <p>
 * 题解：
 * 1.显然是动态规划
 * 2.边界条件： nums==1的时候，那么能抢到的就是nums【0】 ==2的时候，能抢到的是nums【1】和nums【0】中的最大值
 * 3.对于第i个点，能抢到的最大的金钱是num[i-1]或者nums【i-2】+1
 * @see _0213_robberII.Solution
 * @see _0337_robIII.Solution
 *
 */
public class Solution {

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];

    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(rob(input));
    }
}
