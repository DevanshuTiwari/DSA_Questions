package recursion;


class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class SwapNodesRecursion {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Before swapping: ");
        printList(head);


        Node list = swapNodesRecursion(head);
        System.out.println("After swapping: ");
        printList(list);

    }

    private static Node swapNodesRecursion(Node head) {
        if (head == null || head.next == null) return head;

        Node p1 = head;
        Node p2 = head.next;

        p1.next = swapNodesRecursion(p2.next);
        p2.next = p1;

        return p2;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }
}
