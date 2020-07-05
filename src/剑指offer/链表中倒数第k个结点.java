package 剑指offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个结点 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，
     * 而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     *

     */
    public static ListNode FindKthToTail(ListNode head,int k) {

        ListNode fast=head;
        ListNode slow=head;
        int times=k;
        while(null!=fast &&  times-->0){
            fast=fast.next;
        }
        if(times>0){
            return null;
        }
        while(null!=fast){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(FindKthToTail(head,6).val);
    }
}
