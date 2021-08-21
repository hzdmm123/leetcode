package _0056_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hzdmm123
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        start[0] = intervals[0][0];
        end[0] = intervals[0][1];
        int current = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end[current]) {
                end[current] = Math.max(intervals[i][1], end[current]);
                continue;
            } else {
                current++;
                start[current] = intervals[i][0];
                end[current] = intervals[i][1];
            }
        }

        int[][] res = new int[current + 1][2];
        for (int i = 0; i < current + 1; i++) {
            res[i][0] = start[i];
            res[i][1] = end[i];
        }

        return res;
    }

    public int[][] merge2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(o1 -> o1[0]));

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
