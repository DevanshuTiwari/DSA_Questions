package linkedlist.cycledetectnode;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class CycleStartingPoint {
    public static void main(String[] args) {

        int[] values = {3, 2, 0, -4};
        int pos = 1;

        ListNode head = createLinkedList(values, pos);

        ListNode cycleNode = detectCycleStartingNode(head);
        printCycleResult(cycleNode);

    }

    public static ListNode detectCycleStartingNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }

    public static ListNode createLinkedList(int[] values, int pos) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode cycleNode = null;

        for (int i = 0; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
            if (i == pos) {
                cycleNode = curr; // store node where cycle should begin
            }
        }

        if (pos != -1) {
            curr.next = cycleNode; // connect tail to cycle start
        }

        return dummy.next;
    }

    public static void printCycleResult(ListNode node) {
        if (node == null) {
            System.out.println("No cycle detected");
        } else {
            System.out.println("Cycle begins at node with value: " + node.val);
        }
    }
}
