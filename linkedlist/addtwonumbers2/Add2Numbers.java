package linkedlist.addtwonumbers2;


import java.util.Stack;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class Add2Numbers {
    public static void main(String[] args) {
        int[] l1 = {7, 2, 4, 3};
        int[] l2 = {5, 6, 4};

        ListNode list1 = createLinkedList(l1);
        ListNode list2 = createLinkedList(l2);

        System.out.print("List 1: ");
        printLinkedList(list1);

        System.out.print("List 2: ");
        printLinkedList(list2);


        ListNode result = addNumbers(list1, list2);

        System.out.print("Resultant list: ");
        printLinkedList(result);
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode resHead = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = (!s1.isEmpty()) ? s1.pop() : 0;
            int b = (!s2.isEmpty()) ? s2.pop() : 0;

            int sum = a + b + carry;
            carry = sum / 10;
            int digit = sum % 10;

            ListNode newNode = new ListNode(digit);
            newNode.next = resHead;
            resHead = newNode;
        }

        return resHead;
    }

    // Approach with reverse
//    public static ListNode addNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode curr = dummyHead;
//
//        ListNode p1 = reverse(l1);
//        ListNode p2 = reverse(l2);
//
//        int carry = 0;
//
//        while (p1 != null || p2 != null || carry != 0) {
//            int a = (p1 != null) ? p1.data : 0;
//            int b = (p2 != null) ? p2.data : 0;
//
//            int sum = a + b + carry;
//            carry = sum / 10;
//            int digit = sum % 10;
//
//            curr.next = new ListNode(digit);
//            curr = curr.next;
//
//            if (p1 != null) p1 = p1.next;
//            if (p2 != null) p2 = p2.next;
//        }
//
//        return reverse(dummyHead.next);
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
