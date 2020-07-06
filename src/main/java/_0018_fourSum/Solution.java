package _0018_fourSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzdmm123
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 获取当前K的最小值
            int currentIndexMin = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (currentIndexMin > target) {
                continue;
            }

            // 获取当前index的最大值
            int currentIndexMax = nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1];
            if (currentIndexMax < target) {
                continue;
            }

            for (int k = i + 1; k < length - 2; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }

                int j = k + 1;
                int h = length - 1;
                int min = nums[i] + nums[k] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }

                int max = nums[i] + nums[k] + nums[h - 1] + nums[h];
                if (max < target) {
                    continue;
                }

                while (j < h) {
                    int current = nums[i] + nums[k] + nums[j] + nums[h];
                    if (current == target) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h + 1] == nums[h]) {
                            h--;
                        }
                    } else if (current > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;

    }
}
