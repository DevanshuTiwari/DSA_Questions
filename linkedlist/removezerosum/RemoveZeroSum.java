package linkedlist.removezerosum;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class RemoveZeroSum {
    public static void main(String[] args) {
        int[] input = {1, 2, -3, 3, 1};

        ListNode list = createLinkedList(input);
        System.out.print("Original list:  ");
        printLinkedList(list);

        ListNode res = removeNodesEqualToZero(list);
        System.out.print("List after removing nodes: ");
        printLinkedList(res);

    }

    public static ListNode removeNodesEqualToZero(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> mpp = new HashMap<>();
        int prefixSum = 0;

        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.data;
            mpp.put(prefixSum, curr);
        }

        prefixSum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.data;
            curr.next = mpp.get(prefixSum).next;
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
