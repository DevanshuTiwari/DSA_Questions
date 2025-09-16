package linkedlist.removefromend;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int n = 2;

        ListNode list = createLinkedList(input);
        System.out.print("Before deletion: ");
        printLinkedList(list);

        ListNode res = removeNthNodeFromEnd(list, n);
        System.out.print("After deletion: ");
        printLinkedList(res);
    }

    // Approach without reverse -------> TC and SC is same for both approaches
    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return dummy.next;
    }

//   Approach with reverse overhead
//    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {
//        if (head == null) return null;
//
//        ListNode reverseNode = reverse(head);
//        ListNode curr = reverseNode;
//        ListNode prev = null;
//        int count = 1;
//
//
//        while (curr != null) {
//            if (count == n) {
//                if (prev == null) {
//                    reverseNode = curr.next;
//                } else {
//                    prev.next = curr.next;
//                }
//                break;
//            }
//            prev = curr;
//            curr = curr.next;
//            count++;
//        }
//
//        return reverse(reverseNode);
//
//    }
//
//    private static ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode prev = null;
//        ListNode curr = head;
//        ListNode temp = head;
//
//        while (curr != null) {
//            temp = temp.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//
//        return prev;
//    }

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
