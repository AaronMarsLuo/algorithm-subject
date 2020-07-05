package leetcode;

import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que234_回文链表 {
     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
         if(null==head ){
             return true;
         }
        ListNode slow=head,fast=head;
        while(null!=fast){
            if(null==fast.next || null==fast.next.next){
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode middle=reverse(slow.next);
        ListNode start=head;
        while(null!=middle){
            if (start.val!=middle.val) {
                return false;
            }
            start=start.next;
            middle=middle.next;
        }
        reverse(slow.next);
        return true;

    }

    public ListNode reverse(ListNode head){
         if(null==head || null==head.next){
             return head;
         }
         ListNode p=head;
         ListNode q=p.next;
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
