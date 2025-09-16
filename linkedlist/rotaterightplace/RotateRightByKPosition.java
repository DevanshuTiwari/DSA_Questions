package linkedlist.rotaterightplace;


import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class RotateRightByKPosition {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int k = 2;

        ListNode list = createLinkedList(input);
        System.out.print("Before rotation: ");
        printLinkedList(list);

        ListNode result = rotateRightByKPosition(list, k);
        System.out.print("After rotation: ");
        printLinkedList(result);

    }

    public static ListNode rotateRightByKPosition(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        if(k == 0) return head;

        tail.next = head;

        ListNode newTail = head;
        for(int i = 0; i < len - k - 1; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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
