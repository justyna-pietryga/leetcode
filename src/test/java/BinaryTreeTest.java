import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void nullTest() {
        assertEquals(Arrays.asList(), BinaryTree.treeByLevels(null));
    }

    @Test
    public void basicTest() {
        assertEquals(Arrays.asList(1,2,3,4,5,6),
                BinaryTree.treeByLevels(
                        new BinaryTree.Node(
                                new BinaryTree.Node(null, new BinaryTree.Node(null, null, 4), 2),
                                new BinaryTree.Node(new BinaryTree.Node(null, null, 5), new BinaryTree.Node(null, null, 6), 3),
                                1)));
    }
}