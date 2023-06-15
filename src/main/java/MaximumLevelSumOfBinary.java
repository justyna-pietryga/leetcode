import java.util.HashMap;
import java.util.Map;

/**
 * 15-06-2023
 * <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree"/>
 */

public class MaximumLevelSumOfBinary {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sumByLevel = new HashMap<>();
        dfs(root, sumByLevel, 1);

        return sumByLevel.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public void dfs(TreeNode node, Map<Integer, Integer> sumByLevel, int level) {
        if (node == null) return;
        sumByLevel.merge(level, node.val, Integer::sum);
        dfs(node.left, sumByLevel, level + 1);
        dfs(node.right, sumByLevel, level + 1);
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
