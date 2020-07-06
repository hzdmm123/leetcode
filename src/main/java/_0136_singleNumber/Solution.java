package _0136_singleNumber;

/**
 * @author hzdmm123
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *
 * 方法1 ： hashMap
 * 方法2 ：位运算
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}