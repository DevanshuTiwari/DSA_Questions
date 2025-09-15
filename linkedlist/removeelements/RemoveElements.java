package linkedlist.removeelements;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class RemoveElements {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 6, 4, 5, 6};
        int val = 6;
        ListNode list = createLinkedList(input);

        System.out.print("Before deletion: ");
        printLinkedList(list);

        ListNode ans = removeElementsFromList(list, val);
        System.out.print("After deletion: ");
        printLinkedList(ans);
    }

    public static ListNode removeElementsFromList(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
            }

            temp = temp.next;
        }

        return head;
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
