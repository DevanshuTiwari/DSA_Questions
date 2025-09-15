package linkedlist.palindromiclist;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class PalindromicLinkedList {
    public static void main(String[] args) {
        int[] input = {1, 2, 2, 1};
        ListNode list = createLinkedList(input);


        printLinkedList(list);

        boolean ans = isPalindrome(list);
        System.out.println(ans);

    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode midNode = getMidNode(head);
        ListNode reverseNode = reverse(midNode);

        ListNode p1 = head;
        ListNode p2 = reverseNode;
        boolean flag = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                flag = false;
                break;
            }

            p1 = p1.next;
            p2 = p2.next;
        }
        return flag;
    }

    private static ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
