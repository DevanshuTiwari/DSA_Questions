package linkedlist.oddevenlist;


import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        ListNode list = createLinkedList(input);

        System.out.print("Before rearrangement: ");
        printLinkedList(list);

        ListNode res = oddEvenList(list);
        System.out.print("After rearrangement: ");
        printLinkedList(res);

    }

    public static ListNode oddEvenList(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even =  even.next;
        }

        odd.next = evenHead;

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
