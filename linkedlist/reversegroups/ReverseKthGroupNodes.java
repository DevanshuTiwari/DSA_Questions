package linkedlist.reversegroups;


import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class ReverseKthGroupNodes {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        ListNode list = createLinkedList(input);
        System.out.print("Before reversing k nodes: ");
        printLinkedList(list);


        ListNode res = reverseKth(list, k);
        System.out.print("After reversing k nodes: ");
        printLinkedList(res);

    }

    public static ListNode reverseKth(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode groupStart = head;
        ListNode prevGroupEnd = null;

        while (groupStart != null) {
            ListNode groupEnd = getKthNode(groupStart, k);
            if (groupEnd == null) {
                if (prevGroupEnd != null) prevGroupEnd.next = groupStart;
                break;
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;

            reverse(groupStart);

            if (groupStart == head) head = groupEnd;
            else {
                prevGroupEnd.next = groupEnd;
            }

            prevGroupEnd = groupStart;
            groupStart = nextGroupStart;
        }

        return head;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        k--;

        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }

        return temp;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;

        while (curr != null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
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
