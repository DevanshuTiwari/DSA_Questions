package linkedlist.reversebetween;


import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class ReverseBetweenGivenRange {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int left = 2;
        int right = 4;

        ListNode list = createLinkedList(input);
        System.out.print("Before reverse: ");
        printLinkedList(list);

        ListNode res = reverseBetween(list, left, right);
        System.out.print("After reverse: ");
        printLinkedList(res);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode then = null;

        for (int i = 0; i < right - left; i++) {
            then = curr.next;
            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;
        }

        return dummy.next;
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
