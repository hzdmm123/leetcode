package _0220_containsNearbyAlmostDuplicate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hzdmm123
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1.首先了解一下什么是treeSet
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {

            // 返回最小的比nums[i]大的数
            Integer s = set.ceiling(nums[i]);
            if (s != null && s - t <= nums[i]) {
                return true;
            }

            // 返回最大的比nums[i]小的数字
            Integer g = set.floor(nums[i]);
            if (g != null && g + t >= nums[i]) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateII(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }

        Map<Long, Long> bucket = new HashMap<>();
        Long bucketNums = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], bucketNums);
            if (bucket.containsKey(id)) {
                return true;
            }

            if (bucket.containsKey(id - 1) && Math.abs(nums[i] - bucket.get(id - 1)) < bucketNums) {
                return true;
            }

            if (bucket.containsKey(id + 1) && Math.abs(nums[i] - bucket.get(id + 1)) < bucketNums) {
                return true;
            }

            bucket.put(id, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getBucketId(nums[i - k], bucketNums));
            }

        }
        return false;

    }

    private long getBucketId(long value, long w) {
        return value < 0 ? value + 1 / w - 1 : value / w;
    }

}
