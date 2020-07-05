package 其他;

import java.util.List;

/**
 *
 */
public class 按数量K反转链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode head) {
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
    public ListNode reverseList(ListNode head,ListNode end){
        if(null==head){
            return head;
        }
        ListNode p=head;
        ListNode q=p.next;
        while(p!=end){
            ListNode r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        return p;
    }
    public ListNode reverseListByK(ListNode head,int k){
        ListNode newHead=reverseList(head);
        ListNode left=newHead;
        ListNode right=newHead;
        int gap=k;
        while((gap--)>1 && null!=right){
            right=right.next;
        }
        return null;
    }
}
