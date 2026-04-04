package LinkedList;

public class DetectLloopinLL {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false; // An empty list cannot have a cycle
        }

        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode fast = head; // Fast pointer moves two steps at a time

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            if (slow == fast) {
                return true; // A cycle is detected
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a cycle for testing
        head.next.next.next.next = head.next; // Creates a cycle

        DetectLloopinLL solution = new DetectLloopinLL();
        boolean hasCycle = solution.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}
