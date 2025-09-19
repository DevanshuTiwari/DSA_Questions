package linkedlist.mergeksortedlists;


import java.util.PriorityQueue;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class MergeSortedK {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6}
        };

        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = createLinkedList(arr[i]);
            System.out.print("List " + (i + 1) + ": ");
            printLinkedList(lists[i]);
        }

        // Merge them
        ListNode merged = mergeKLists(lists);
        System.out.print("Merged List: ");
        printLinkedList(merged);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head); // add all the heads of given lists
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();

            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;

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
