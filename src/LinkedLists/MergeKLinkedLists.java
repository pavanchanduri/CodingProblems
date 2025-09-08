package LinkedLists;

import java.util.PriorityQueue;
import java.util.Comparator;

class ListNode {
    int data;
    ListNode next;
    ListNode() {}
    ListNode(int data) { this.data = data; }
    ListNode(int data, ListNode next) { this.data = data; this.next = next; }
}

public class MergeKLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6, new ListNode(8)));

        // Array of linked lists
        ListNode[] lists = {list1, list2, list3};

        ListNode mergedList = mergeKLists(lists);
        printList(mergedList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Merge the k lists using a priority queue (min-heap)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list); // Add only non-null lists
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
            if (current.next != null) minHeap.offer(current.next);
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
