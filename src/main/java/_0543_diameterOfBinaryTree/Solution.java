package _0543_diameterOfBinaryTree;

/**
 * @author hzdmm123
 */
public class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max;
    }

    public int getMaxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftHeight = getMaxDepth(node.left);
        int rightHeight = getMaxDepth(node.right);
        max = Math.max(max, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
