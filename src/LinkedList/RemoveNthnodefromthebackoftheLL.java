package LinkedList;

public class RemoveNthnodefromthebackoftheLL {
    public ListNode removeNthFromEnd(ListNode head,int n){
        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        if(cnt==n) return head.next;
        temp=head;
        int res=cnt-n;
        for(int i=1;i<res;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthnodefromthebackoftheLL obj=new RemoveNthnodefromthebackoftheLL();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int n=2;
        ListNode ans=obj.removeNthFromEnd(head,n);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans=ans.next;
        }
    }
}
