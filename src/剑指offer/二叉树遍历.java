package 剑指offer;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树遍历 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //前序遍历递归
    public static void preOrderTraverse1(TreeNode t) {
        if (null != t) {
            System.out.print(t.val + " ");
            preOrderTraverse1(t.left);
            preOrderTraverse1(t.right);
        }
    }

    //前序遍历非递归
    public static void preOrderTraverse2(TreeNode t) {
        Stack<TreeNode> L = new Stack<>();
        TreeNode now = t;
        while (null != now || !L.isEmpty()) {
            if (null != now) {
                L.push(now);
                System.out.print(now.val + " ");
                now = now.left;
            } else {
                now = L.pop().right;
            }
        }
    }

    //中序遍历递归
    public static void inOrderTraverse1(TreeNode t) {
        if (null != t) {
            inOrderTraverse1(t.left);
            System.out.print(t.val + " ");
            inOrderTraverse1(t.right);
        }
    }

    //中序遍历非递归
    public static void inOrderTraverse2(TreeNode t) {
        Stack<TreeNode> L = new Stack<>();
        TreeNode now = t;
        while (null != now || !L.isEmpty()) {
            if (null != now) {
                L.push(now);
                now = now.left;
            } else {
                System.out.print(L.peek().val + " ");
                now = L.pop().right;
            }
        }
    }

    //后序遍历递归
    public static void postOrderTraverse1(TreeNode t) {
        if (null != t) {
            postOrderTraverse1(t.left);
            postOrderTraverse1(t.right);
            System.out.print(t.val + " ");
        }
    }

    //后序遍历非递归
    public static void postOrderTraverse2(TreeNode t) {
        Stack<TreeNode> L = new Stack<>();
        TreeNode now = t;
        TreeNode flag = null;
        while (null != now || !L.isEmpty()) {
            if (null != now) {
                L.push(now);
                now = now.left;
            } else {
                now = L.peek();
                if (null != now.right && now.right != flag) {
                    now = now.right;
                } else {
                    now = L.pop();
                    System.out.print(now.val + " ");
                    flag = now;
                    now = null;
                }
            }
        }
    }

    //层次遍历
    public static void levelOrderTraverse(TreeNode t){
       Queue<TreeNode> L=new LinkedList<>();
       TreeNode now=t;
       L.add(now);
       while (!L.isEmpty()){
           now=L.remove();
           System.out.print(now.val+" ");
           if(null!=now.left){
               L.add(now.left);
           }
           if(null!=now.right){
               L.add(now.right);
           }
       }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(6);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(8);
        //前序遍历
        preOrderTraverse1(t);
        System.out.println();
        preOrderTraverse2(t);
        System.out.println();
        //中序遍历
        inOrderTraverse1(t);
        System.out.println();
        inOrderTraverse2(t);
        System.out.println();
        //后序遍历
        postOrderTraverse1(t);
        System.out.println();
        postOrderTraverse2(t);
        System.out.println();
        //层次遍历
        levelOrderTraverse(t);
        System.out.println();
    }
}
