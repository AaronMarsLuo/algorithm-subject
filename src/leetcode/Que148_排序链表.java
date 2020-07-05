package leetcode;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que148_排序链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode sortList(ListNode head) {
        if(null==head || null==head.next){
            return head;
        }
        ListNode slow=head,fast=head;
        while(null!=fast){
            if(null==fast.next || null==fast.next.next){
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        ListNode l=sortList(head);
        ListNode r=sortList(right);
        return combine(l,r);
    }
    public ListNode combine(ListNode l1,ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode now=head;
        while(null!=l1 && null!=l2){
            if(l1.val<l2.val){
                head.next=new ListNode(l1.val);
                head=head.next;
                l1=l1.next;
            }else{
                head.next=new ListNode(l2.val);
                head=head.next;
                l2=l2.next;
            }
        }
        head.next=null!=l1?l1:l2;
        return now.next;
    }
}
