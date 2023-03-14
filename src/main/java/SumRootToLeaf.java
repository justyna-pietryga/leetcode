/**
 * 14-03-2023
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers"/>
 */
class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }

    private int recursive(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) return sum;
        return recursive(node.left, sum) + recursive(node.right, sum);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}