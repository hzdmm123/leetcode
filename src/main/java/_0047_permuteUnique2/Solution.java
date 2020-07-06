package _0047_permuteUnique2;

import java.util.*;

/**
 * @author hzdmm123
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        help(nums, 0, path, used, res);
        return res;

    }

    private void help(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            help(nums, depth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }

    }
}
