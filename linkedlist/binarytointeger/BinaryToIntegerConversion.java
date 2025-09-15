package linkedlist.binarytointeger;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class BinaryToIntegerConversion {
    public static void main(String[] args) {
        int[] input = {1, 0, 1};
        ListNode list = createLinkedList(input);

        int ans = getIntegerFromBinary(list);
        System.out.println(ans);
    }

    public static int getIntegerFromBinary(ListNode head) {
        if (head == null) return 0;

        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.data;
            // bit manipulation -> ans = (ans << 1) | head.data
            head = head.next;
        }

        return ans;
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
