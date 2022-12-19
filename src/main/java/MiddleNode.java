import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleNode {
    public ListNode middleNode(ListNode head) {
        List<ListNode> history = new ArrayList<>();
        ListNode slow = head, fast = head;
        System.out.println(slow);
        System.out.println(fast);
        System.out.println(head);

        int i = 3;
        Integer a = i;
//        a = a + 5;

        Map<Integer, Integer> or = new TreeMap<>();
        or.put(2, 12);
        or.put(3, 1);
        or.put(1, 1);
        System.out.println(or);

        System.out.println("sprawdzam: " + (a == i));
        System.out.println("sprawdzam: " + i);

        String text1 = "Test1";
        String text2 = "Test1";
        String text3 = "Test3";

        Set<String> set = new HashSet<>();
        set.add(text1);
        set.add(text2);
        set.add(text3);






        Boolean b1;
        boolean b2;
        b1 = true;
        b2 = true;
        System.out.println(set.size());
        while (fast != null && fast.next != null) {
            slow = slow.next;
            System.out.println(slow.val);
            System.out.println(slow);
            fast = fast.next.next;
            System.out.println(fast.val);
            System.out.println(fast);
            System.out.println("____");
        }
        return slow;

//        while (head.next != null) {
//            history.add(head);
//            head = head.next;
//        }
//        history.add(head);
//
//        return history.get(history.size() / 2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

//        @Override
//        public String toString() {
//            return val + "";
//        }
    }
}