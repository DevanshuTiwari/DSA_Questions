package linkedlist.doublylinkedlist;

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        DoublyLinkedListNode list = createDoubleLinkedList(input);

        printDoublyLinkedList(list);


    }

    public static DoublyLinkedListNode createDoubleLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        DoublyLinkedListNode head = new DoublyLinkedListNode(arr[0]);
        DoublyLinkedListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        return head;
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode tail = null;

        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" <-> ");
            tail = curr;
            curr = curr.next;
        }
        System.out.println();

        System.out.print("Backward: ");
        while (tail != null) {
            System.out.print(tail.data);
            if (tail.prev != null) System.out.print(" <-> ");
            tail = tail.prev;
        }
        System.out.println();
    }
}
