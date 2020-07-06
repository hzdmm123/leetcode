package _0040_combinationSum2;

import java.util.*;

/**
 * @author hzdmm123
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayDeque<>(), res);

        return res;

    }

    public void dfs(int[] candidates, int index, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
