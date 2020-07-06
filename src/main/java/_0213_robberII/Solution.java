package _0213_robberII;

/**
 * @author hzdmm123
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 题解：
 * 执行两边198的打家劫舍，0：n-1 1：n
 */
public class Solution {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length == 2 ? Math.max(nums[0], nums[1]) : nums[0];
        }

        int a = doRob(nums, 0, nums.length - 1);
        int b = doRob(nums, 1, nums.length);

        return Math.max(a, b);

    }

    public int doRob(int[] nums, int begin, int end) {
        int pre = 0;
        int cur = 0;
        for (int i = begin; i < end; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }

        return cur;
    }
}
