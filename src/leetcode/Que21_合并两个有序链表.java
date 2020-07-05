package leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que21_合并两个有序链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    //我的想法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode l3;
        if (l1.val < l2.val) {
            l3 = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            l3 = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode l4 = l3;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while (null != l1) {
            l3.next = new ListNode(l1.val);
            l1 = l1.next;
            l3 = l3.next;
        }
        while (null != l2) {
            l3.next = new ListNode(l2.val);
            l2 = l2.next;
            l3 = l3.next;
        }
        return l4;
    }

    public static void printListNode(ListNode l) {
        while (null != l) {
            System.out.print(l.val + ",");
            l = l.next;
        }
        System.out.println("\n----------");
    }

    //改进
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (null != l1) {
            head.next = l1;
        }
        if (null != l2) {
            head.next = l2;
        }
        return result.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists1(l1, l2);
        printListNode(l3);
    }
}

