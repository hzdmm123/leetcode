package _0046_arrangeOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hzdmm123
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        help(results, new ArrayList<Integer>(), nums);
        return results;
    }

    private void help(List<List<Integer>> results, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            results.add(tempList);
        }

        for (int num : nums) {

            if (tempList.contains(num)) {
                continue;
            }

            tempList.add(num);
            help(results, tempList, nums);
            tempList.remove(num);

        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        Boolean[] used = new Boolean[nums.length];

        dfs(nums, 0, used, path, results);
        return results;
    }

    private void dfs(int[] nums, int depth, Boolean[] used, Deque<Integer> path, List<List<Integer>> results) {
        if (depth == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, used, path, results);
            path.removeLast();
            used[i] = false;
        }

    }
}
