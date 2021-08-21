package _0253_minMeetingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hzdmm123
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间
 * intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length <= 1) {
            return intervals.length;
        }

        PriorityQueue<Integer> meetings = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o));
        Arrays.sort(intervals, Comparator.comparing(o1 -> o1[0]));
        meetings.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= meetings.peek()) {
                meetings.poll();
            }

            meetings.add(intervals[i][1]);
        }

        return meetings.size();

    }
}
