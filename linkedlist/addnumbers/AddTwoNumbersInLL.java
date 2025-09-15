package linkedlist.addnumbers;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class AddTwoNumbersInLL {
    public static void main(String[] args) {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};

        ListNode list1 = createLinkedList(l1);
        ListNode list2 = createLinkedList(l2);

        System.out.print("List 1: ");
        printLinkedList(list1);

        System.out.print("List 2: ");
        printLinkedList(list2);


        ListNode result = addLinkedListNumbers(list1, list2);

        System.out.print("Resultant list: ");
        printLinkedList(result);
    }

    public static ListNode addLinkedListNumbers(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        ListNode p1 = head1;
        ListNode p2 = head2;

        int carry = 0;

        while (p1 != null || p2 != null || carry != 0) {
            int a = (p1 != null) ? p1.data : 0;
            int b = (p2 != null) ? p2.data : 0;

            int sum = a + b + carry;
            carry = sum / 10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

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
