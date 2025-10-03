package recursion;

public class LinkedListReverseRecursion {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reverseList = reverseLinkedList(head);
        printList(reverseList);
    }

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head; // 2 -> 3 -------- 3 -> 2
        head.next = null; // 2 -> null

        return newHead;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
