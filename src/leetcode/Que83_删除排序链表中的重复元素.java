package leetcode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que83_删除排序链表中的重复元素 {
    private ListNode p;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (null != head && null != head.next) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return p;
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
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
//        head.next=new ListNode(2);head=head.next;
//        head.next=new ListNode(3);head=head.next;
//        head.next=new ListNode(3);head=head.next;
//        head.next=new ListNode(3);head=head.next;
        print(deleteDuplicates(p));
    }
}
