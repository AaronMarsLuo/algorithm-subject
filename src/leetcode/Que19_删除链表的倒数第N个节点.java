package leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * /**
 *      * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，
 *      * 而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。
 *      * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
 *      * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 *      *
 *
 *      */

public class Que19_删除链表的倒数第N个节点 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val=x;}
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head,r=head;
        int i=0;
        while(q!=null && i<n){
            q=q.next;
            i++;
        }
        if(null==q){
            return r.next;
        }
        while(q.next!=null){
            p=p.next;
            q=q.next;
        }
        p.next = p.next.next;
        return r;
    }
    public static void print(ListNode head) {
        ListNode p = head;
        while (null != p) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        print(removeNthFromEnd(p,1));
    }
}
