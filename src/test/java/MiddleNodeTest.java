import org.junit.Test;

public class MiddleNodeTest {

    @Test
    public void testing() {
        MiddleNode middleNode = new MiddleNode();
        middleNode.middleNode(new MiddleNode.ListNode(1, new MiddleNode.ListNode(2, new MiddleNode.ListNode(3, new MiddleNode.ListNode(4, new MiddleNode.ListNode(5, null))))));
    }
}