package LinkedList;

public class ReorderList {
    public void reorderList(ListNode head){
        if (head==null || head.next==null) return;

        // find the middle of the list
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode prev = null, curr = slow.next;
        while(curr!=null){
            ListNode front= curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        slow.next = null; // split the list into two halves

        // merge the two halves
        ListNode first = head, second = prev;
        while(second!=null){
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rl.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}