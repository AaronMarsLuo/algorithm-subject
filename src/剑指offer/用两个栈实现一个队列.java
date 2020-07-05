package 剑指offer;

import java.util.Stack;

public class 用两个栈实现一个队列 {

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.pop();
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.pop();
        myQueue.pop();
        System.out.println(myQueue.peek());
        myQueue.push(5);
        System.out.println(myQueue.pop());
    }
}
class MyQueue{
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    MyQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void push(int x){
        s1.push(x);
    }
    public int pop(){
        if(s2.isEmpty()){
            shift();
        }
        return s2.pop();
    }
    public int peek(){
        if(s2.isEmpty()){
            shift();
        }
        return s2.peek();
    }
    private void shift(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
}
