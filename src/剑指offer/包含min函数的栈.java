package 剑指offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class 包含min函数的栈 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    包含min函数的栈(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void push(int node) {
        s1.add(node);
        if(s2.isEmpty() || s2.peek()>=node){
            s2.push(node);
        }
    }

    public void pop() {
        int t=s1.pop();
        if(s2.peek()==t){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
