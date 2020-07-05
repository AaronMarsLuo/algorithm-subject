package 剑指offer;

public class 反转链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(null==head){
            return null;
        }
        ListNode p=head;
        ListNode q=head.next;
        p.next=null;
        while(null!=q){
            ListNode r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        return p;
    }
}
