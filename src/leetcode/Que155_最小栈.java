package leetcode;

import java.util.*;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//public class lesson155 {
////    class ListNode{
////        int val;
////        ListNode next;
////        ListNode(int x){this.val=x;}
////    }
////    List<Integer> numbers;
////    ListNode head;
////    /** initialize your data structure here. */
////    public lesson155() {
////        numbers=new ArrayList<>();
////        head=null;
////    }
////
////    public void push(int x) {
////        if(null==head){
////            head=new ListNode(x);
////            numbers.add(x);
////        }else{
////            ListNode now=new ListNode(x);
////            now.next=head;
////            head=now;
////            numbers.add(x);
////        }
////    }
////
////    public void pop() {
////        numbers.remove((Integer)head.val);
////        head=head.next;
////    }
////
////    public int top() {
////        return head.val;
////    }
////
////    public int getMin() {
////        Collections.sort(numbers);
////        return numbers.get(0);
////    }
////
////}
public class Que155_最小栈 {
    Stack<Integer> L;
    /** initialize your data structure here. */
    public Que155_最小栈() {
        L=new Stack<>();
    }

    public void push(int x) {
        if(L.isEmpty()){
            L.push(x);
            L.push(x);
        }else {
            int m=L.peek();
            L.push(x);
            L.push(Math.min(m,x));
        }
    }

    public void pop() {
        L.pop();
        L.pop();
    }

    public int top() {
        return L.get(L.size()-2);
    }

    public int getMin() {
       return L.peek();
    }

}