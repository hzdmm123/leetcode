package _03_lengthOfLongestSubstring;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hzdmm123
 */
public class Solution {

    // 从头开始的话就是滑动窗口
    public int lengthOfLongestSubstringII(String s) {
        int left = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();

        for (int i = 0; i < chars.length - 1; i++) {

            if (hashMap.containsKey(chars[i])) {
                left = Math.max(left, hashMap.get(chars[i]) + 1);// 滑动到出现相同字符串的地方
            }
            hashMap.put(chars[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    // 从后往前
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int maxSize = 0;
        HashSet<Character> characterHashSet = new HashSet();

        for (int i = chars.length - 1; i >= 0; i--) {

            characterHashSet.clear();

            characterHashSet.add(chars[i]);

            for (int j = i - 1; j >= 0; j--) {
                if (characterHashSet.contains(chars[j])) {
                    break;
                }
                characterHashSet.add(chars[j]);
            }

            if (characterHashSet.size() > maxSize) {
                maxSize = characterHashSet.size();
            }

            characterHashSet.clear();
        }

        return maxSize;
    }

    public static void main(String[] args) {
        //孔数组
        //
        List<Integer> result = new ArrayList<>();
        List<String> raw = new ArrayList<>();
        raw.add("1");
        raw.add("2");
        raw.add("3");
        raw.add("4");
        List<Integer> sss = raw.stream().map(a -> add(a)).collect(Collectors.toList());
        sss.forEach(a -> System.out.println(a));
        System.out.println(count);

    }

    public static int count = 0;

    public static int add(String s) {
        count++;
        return Integer.parseInt(s) * Integer.parseInt(s);
    }



}
