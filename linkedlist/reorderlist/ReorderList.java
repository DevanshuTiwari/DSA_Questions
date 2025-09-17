package linkedlist.reorderlist;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class ReorderList {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        ListNode list = createLinkedList(input);
        System.out.print("Before reordering: ");
        printLinkedList(list);

        reorderList(list);
        System.out.print("After reordering: ");
        printLinkedList(list);

    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode midNode = getMiddle(head);
        ListNode reverseHead = reverse(midNode);
        ListNode firstHead = head;

        while (firstHead != null && reverseHead != null) {
            ListNode p1 = firstHead.next;
            ListNode p2 = reverseHead.next;

            firstHead.next = reverseHead;
            reverseHead.next = p1;

            firstHead = p1;
            reverseHead = p2;
        }
    }

    private static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        return secondHead;
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
