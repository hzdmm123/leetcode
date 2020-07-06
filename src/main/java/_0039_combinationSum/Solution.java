package _0039_combinationSum;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author hzdmm123
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, 0, target, candidates, new ArrayDeque<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int index, int target, int[] candidates, Deque<Integer> path) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(result, i, target - candidates[i], candidates, path);
            path.removeLast();
        }
    }

}
