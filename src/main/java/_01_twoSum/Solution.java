package _01_twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author hzdmm123
 */
public class Solution {
    public Solution() {
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 9};
        Solution solution = new Solution();

        int[] res = solution.twoSum(nums, 5);
        Arrays.stream(res).forEach(System.out::println);
    }
}
