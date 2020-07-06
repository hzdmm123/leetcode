package _0337_robIII;

import java.util.HashMap;

/**
 * @author hzdmm123
 */
public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /***
     * 相当慢的递归算法
     * @param root
     * @return
     */
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int subSonsMoney = 0;

        if (root.left != null) {
            subSonsMoney += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            subSonsMoney += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val + subSonsMoney, rob(root.left) + rob(root.right));
    }

    public int robII(TreeNode root) {
        HashMap<TreeNode, Integer> cache = new HashMap<>();
        return robByMinusTHeCount(root, cache);

    }

    public int robByMinusTHeCount(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if (root == null) {
            return 0;
        }

        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        int money = root.val;
        if (root.left != null) {
            money += robByMinusTHeCount(root.left.left, cache) + robByMinusTHeCount(root.left.right, cache);
        }

        if (root.right != null) {
            money += robByMinusTHeCount(root.right.left, cache) + robByMinusTHeCount(root.right.right, cache);
        }

        int max = Math.max(money, robByMinusTHeCount(root.left, cache) + robByMinusTHeCount(root.right, cache));
        cache.put(root, max);

        return max;

    }

    /**
     * 数组 index 0 表示不抢当前节点可以获得的最大钱
     * index 1表示抢当前节点可以获得最大的钱
     *
     * @param treeNode
     * @return
     */
    public int robDp(TreeNode treeNode) {
        int[] res = robInternal(treeNode);
        return Math.max(res[0], res[1]);
    }

    private int[] robInternal(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[2];
        }

        int[] res = new int[2];
        int[] left = robInternal(treeNode.left);
        int[] right = robInternal(treeNode.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + treeNode.val;

        return res;

    }

}
