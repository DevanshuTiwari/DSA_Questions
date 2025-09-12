package linkedlist.removeduplicates;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[] input = {1, 1, 2};
        ListNode head = createLinkedList(input);

        System.out.print("Original List: ");
        printLinkedList(head);

        ListNode result = deleteDuplicates(head);

        System.out.print("After Duplication Delete: ");
        printLinkedList(result);

    }

    public static ListNode deleteDuplicates(ListNode node) {
        if (node == null) return node;

        ListNode temp = node;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                continue;
            }

            temp = temp.next;
        }

        return node;
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
