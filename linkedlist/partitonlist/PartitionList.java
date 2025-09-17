package linkedlist.partitonlist;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class PartitionList {
    public static void main(String[] args) {
        int[] input = {1, 4, 3, 2, 5, 2};
        int x = 3;

        ListNode list = createLinkedList(input);
        System.out.print("Before partition: ");
        printLinkedList(list);

        ListNode res = partition(list, x);
        System.out.print("After partition: ");
        printLinkedList(res);

    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessThanXHead = new ListNode(0);
        ListNode lessThanXTail = lessThanXHead;

        ListNode greaterThanOrEqualXHead = new ListNode(0);
        ListNode greaterThanOrEqualXTail = greaterThanOrEqualXHead;

        ListNode curr = head;

        while (curr != null) {
            if (curr.data < x) {
                lessThanXTail.next = curr;
                lessThanXTail = lessThanXTail.next;
            } else {
                greaterThanOrEqualXTail.next = curr;
                greaterThanOrEqualXTail = greaterThanOrEqualXTail.next;
            }

            curr = curr.next;
        }

        greaterThanOrEqualXTail.next = null;
        lessThanXTail.next = greaterThanOrEqualXHead.next;


        return lessThanXHead.next;
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
