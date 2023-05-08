public class BinaryTreeCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null) {
            return false;
        }

        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }

    private boolean helper(TreeNode treeNode, boolean isLeftAlone) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return true;
        }
        if (treeNode.left == null ) {
            return false;
        }

        return helper(treeNode.left, false) && helper(treeNode.right, false);
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
