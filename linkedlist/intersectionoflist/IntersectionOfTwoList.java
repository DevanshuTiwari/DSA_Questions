package linkedlist.intersectionoflist;


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class IntersectionOfTwoList {
    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        System.out.print("List A: ");
        printLinkedList(headA);

        System.out.print("List B: ");
        printLinkedList(headB);

        ListNode ans = getIntersectionNode(headA, headB);
        if (ans != null) {
            System.out.println("Intersection at node with value: " + ans.data);
        } else {
            System.out.println("No intersection");
        }
    }

    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;

        ListNode p1 = A;
        ListNode p2 = B;

        while (p1 != p2) {
            p1 = (p1 == null) ? B : p1.next;
            p2 = (p2 == null) ? A : p2.next;
        }

        return p1;
    }


//   Approach with helper function
//    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
//
//        int lenA = getLength(A);
//        int lenB = getLength(B);
//
//        while (lenA > lenB) {
//            A = A.next;
//            lenA--;
//        }
//
//        while (lenB > lenA) {
//            B = B.next;
//            lenB--;
//        }
//
//        while (A != null && B != null) {
//            if (A == B) {
//                return A;
//            }
//            A = A.next;
//            B = B.next;
//        }
//
//        return null;
//
//    }
//
//    private static int getLength(ListNode node) {
//        int len = 0;
//        while (node != null) {
//            len++;
//            node = node.next;
//        }
//
//        return len;
//    }


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
