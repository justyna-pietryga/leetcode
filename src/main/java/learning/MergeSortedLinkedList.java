package learning;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/"/>
 */
public class MergeSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divideAndMerge(lists, 0, lists.length - 1);
    }

    private ListNode divideAndMerge(ListNode[] listNodes, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return listNodes[startIndex];
        }

        int mid = (endIndex - startIndex) / 2 + startIndex;

        ListNode left = divideAndMerge(listNodes, startIndex, mid);
        ListNode right = divideAndMerge(listNodes, mid + 1, endIndex);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode first = new ListNode();
        ListNode tmp = first;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = new ListNode(left.val);
                left = left.next;
            } else {
                tmp.next = new ListNode(right.val);
                right = right.next;
            }
            tmp = tmp.next;
        }

        while (left != null) {
            tmp.next = new ListNode(left.val);
            left = left.next;
            tmp = tmp.next;
        }

        while (right != null) {
            tmp.next = new ListNode(right.val);
            right = right.next;
            tmp = tmp.next;
        }

        return first.next;
    }

    public class ListNode {
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
    }
}
