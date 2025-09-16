package linkedlist.swapnodes;

import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class SwapAdjacentNodes {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        ListNode list = createLinkedList(input);

        System.out.print("Before swapping: ");
        printLinkedList(list);

        ListNode res = swapNodes(list);
        System.out.print("After swapping: ");
        printLinkedList(res);
    }

    public static ListNode swapNodes(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode p1 = prev.next;
            ListNode p2 = prev.next.next;

            // swapping
            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            // move prev pointer where p1 is located.
            prev = p1;
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
