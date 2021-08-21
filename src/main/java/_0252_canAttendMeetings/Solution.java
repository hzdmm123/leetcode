package _0252_canAttendMeetings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hzdmm123
 * 252. 会议室
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间
 * intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 */

// 一个能否参加所有会议应该由会议的开始时间的和结束时间确定，将所有的会议以开始时间排序
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 1) {
            return true;
        }


        for (int i = intervals.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (intervals[j][0] < intervals[j - 1][0]) {
                    swap(j, j - 1, intervals);
                }
            }
        }

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;

    }

    public boolean canAttendMeetings2(int[][] intervals) {

        if (intervals.length == 1) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;


    }


    public void swap(int i, int j, int[][] intervals) {
        int temp1 = intervals[j][0];
        int temp2 = intervals[j][1];
        intervals[j][0] = intervals[i][0];
        intervals[j][1] = intervals[i][1];
        intervals[i][0] = temp1;
        intervals[i][1] = temp2;
    }
}
