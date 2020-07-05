package leetcode;

import java.util.*;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que141_环形链表 {
    static class  ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> L=new HashSet<>();
        ListNode now=head;
        while(null!=now){
            if(L.contains(now)){
                return true;
            }
            L.add(now);
            now=now.next;
        }
        return false;
    }
    public boolean hasCycle1(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (null!=fast){
            slow=slow.next;
            int n=2;
            while(null!=fast && n-->0) {
                fast = fast.next;
            }
            if(null==fast){
                return false;
            }
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode s=new ListNode(2);
        ListNode t=s.next;
        System.out.println(null==s.next);
        t=new ListNode(3);
        System.out.println(null==s.next);
    }
}
