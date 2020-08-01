package _0016_threeSumClosest;

import java.util.Arrays;

/**
 * @author hzdmm123
 * <p>
 * 排序+双指针
 */
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] params = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(params, target));

    }

}
