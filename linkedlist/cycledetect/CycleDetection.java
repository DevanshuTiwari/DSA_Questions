package linkedlist.cycledetect;


import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class CycleDetection {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = createLinkedList(input);

        ListNode curr = head;
        ListNode cyclePoint = null;

        while (curr.next != null) {
            if (curr.data == 2) {
                cyclePoint = curr;  // store reference to node 4
            }
            curr = curr.next;
        }
        curr.next = cyclePoint;  // last node points to node 4

        boolean ans = isCycle(head);
        System.out.println(ans);

    }

    public static boolean isCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

}
