package linkedlist.deletenode;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}


public class DeleteNode {
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 9};
        ListNode head = createLinkedList(input);

        System.out.print("Original List: ");
        printLinkedList(head);


        ListNode nodeToDelete = head.next; // this points to node with value 5

        deleteNode(nodeToDelete);

        System.out.print("After Deletion: ");
        printLinkedList(head);
    }

    public static void deleteNode(ListNode node) {

        if (node == null || node.next == null) return;
        node.data = node.next.data;
        node.next = node.next.next;

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
