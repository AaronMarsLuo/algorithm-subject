package 剑指offer;

public class 合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode l3=new ListNode(-1);
        ListNode head=l3;
        while(null!=l1 && null!=l2){
            if(l1.val<l2.val){
                l3.next=new ListNode(l1.val);
                l1=l1.next;
            } else{
                l3.next=new ListNode(l2.val);
                l2=l2.next;
            }
            l3=l3.next;
        }
        if(null!=l1){
            l3.next=l1;
        }
        if(null!=l2){
            l3.next=l2;
        }
        return head.next;
    }
}
