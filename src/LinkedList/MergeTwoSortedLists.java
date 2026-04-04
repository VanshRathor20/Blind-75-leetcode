package LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to help with merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1; // Attach l1 node to the merged list
                l1 = l1.next; // Move to the next node in l1
            } else {
                current.next = l2; // Attach l2 node to the merged list
                l2 = l2.next; // Move to the next node in l2
            }
            current = current.next; // Move the current pointer
        }

        // If there are remaining nodes in either list, attach them
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // The head of the merged list is the next of dummy
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode mergedHead = solution.mergeTwoLists(l1, l2);

        // Print the merged list
        ListNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
