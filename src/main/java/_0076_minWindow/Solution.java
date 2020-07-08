package _0076_minWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzdmm123
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // 生成t字符串的字典
        Map<Character, Integer> dictT = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int requireSize = dictT.size();
        int left = 0;
        int right = 0;

        // 表示的是非重复的字符串个数,abc
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == requireSize) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                left++;
            }
            right++;


        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

}