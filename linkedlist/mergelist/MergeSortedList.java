package linkedlist.mergelist;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class MergeSortedList {
    public static void main(String[] args) {
        int[] input = {1, 2, 4};
        int[] input2 = {1, 3, 4};
        ListNode l1 = createLinkedList(input);
        ListNode l2 = createLinkedList(input2);

        ListNode result = mergeTwoSortedList(l1, l2);


        printLinkedList(result);

    }

    public static ListNode mergeTwoSortedList(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                tail.next = h1;
                h1 = h1.next;
                tail = tail.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
                tail = tail.next;
            }
        }

        tail.next = (h1 != null) ? h1 : h2;
        return dummyHead.next;
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
