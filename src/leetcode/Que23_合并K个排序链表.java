package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que23_合并K个排序链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode p = combine(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            p = combine(p, lists[i]);
        }
        return p;
    }

    public static ListNode combine(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
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

    public static ListNode createNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * 方法2
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        for (ListNode i:lists){
            if(null!=i){
                pq.add(i);
            }
        }
        ListNode head=new ListNode(0);
        ListNode p=head;
        while (!pq.isEmpty()){
            ListNode top=pq.poll();
            p.next=top;
            p=p.next;
            if(null!=top.next){
                pq.add(top.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 4, 5};
        int[] nums2 = new int[]{1, 3, 4};
        int[] nums3 = new int[]{2, 6};
        ListNode[] list = new ListNode[]{createNode(nums1), createNode(nums2), createNode(nums3)};
        ListNode p = mergeKLists2(list);
        print(p);
    }
}
