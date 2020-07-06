package _0216_combinationSum3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hzdmm123
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (k <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, n, res, new ArrayDeque<>(), k);
        return res;
    }

    private void dfs(int[] candidates, int index, int target, List<List<Integer>> res, Deque<Integer> path, int nums) {

        if (nums == 0 && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (nums == 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], res, path, nums - 1);
            path.removeLast();
        }
    }
}
