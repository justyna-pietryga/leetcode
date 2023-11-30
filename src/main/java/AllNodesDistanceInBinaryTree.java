import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceInBinaryTree {
    Map<Integer, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findTarget(root, target, k, result, null);

        return result;
    }

    private void findTarget(TreeNode node, TreeNode target, int k, List<Integer> result, TreeNode parent) {
        if (node == null) return;
        if (parent != null) parents.put(node.val, parent);
        if (node.val == target.val) {
            another(node, k, result);
            another(parents.get(node.val), k - 1, result);
        } else {
            findTarget(node.left, target, k, result, node);
            findTarget(node.right, target, k, result, node);
        }
    }

    private void another(TreeNode node, int k, List<Integer> result) {
        if (node != null) {
            if (k <= 0) {
                result.add(node.val);
            }
            another(node.left, k - 1, result);
            another(node.right, k - 1, result);
        }
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
