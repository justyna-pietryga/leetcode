import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryTree {
    private static final Map<Integer, List<Integer>> valuesByLevels = new HashMap<>();

    public static List<Integer> treeByLevels(Node node) {
        if (node != null) System.out.println(node.value);
        if (node.left != null) System.out.println("left: " + node.left.value);
        if (node.right != null) System.out.println("right: " + node.right.value);

        if (node != null) {
            valuesByLevels.put(0, Collections.singletonList(node.value));
            valuesByLevels.entrySet()
                    .forEach(System.out::println);
            addValuesByLevel(1, node);
        } else {
            return Collections.emptyList();
        }

        return valuesByLevels.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

    }

    private static void addValuesByLevel(int level, Node node) {
        List<Integer> values = valuesByLevels.getOrDefault(level, new ArrayList<>());
        Node nodeLeft = node.left;
        Node nodeRight = node.right;

        if (nodeLeft != null) {
            values.add(nodeLeft.value);
            addValuesByLevel(level + 1, nodeLeft);
        }
        if (nodeRight != null) {
            values.add(nodeRight.value);
            addValuesByLevel(level + 1, nodeRight);
        }

        valuesByLevels.put(level, values);
        valuesByLevels.entrySet()
                .forEach(System.out::println);
    }

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(Node l, Node r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }
}
