package _0209_minsubArrayLen;

/**
 * @author hzdmm123
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Soultion {

    public int minSubArrayLen(int s, int[] nums) {
        int length = 0;
        int tempSum = 0;
        int index = 0;

        for (int j = 0; j < nums.length; j++) {
            tempSum += nums[j];
            while (tempSum >= s) {
                length = length == 0 ? j - index + 1 : Math.min(length, j - index + 1);
                tempSum -= nums[index++];
            }
        }

        return length;
    }

}
