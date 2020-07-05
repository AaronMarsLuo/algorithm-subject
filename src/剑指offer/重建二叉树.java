package 剑指offer;

import java.util.*;
import java.lang.System;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class 重建二叉树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }
    //通过前序遍历和中序遍历重构二叉树
    public static TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        int root=pre[0];
        int rootId=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==root){
                rootId=i;
                break;
            }
        }
        TreeNode head=new TreeNode(root);
        int[] leftPre=new int[rootId];
        int[] rightPre=new int[pre.length-1-rootId];
        int[] leftIn=new int[rootId];
        int[] rightIn=new int[pre.length-1-rootId];
        System.arraycopy(pre,1,leftPre,0,rootId);
        System.arraycopy(pre,rootId+1,rightPre,0,pre.length-1-rootId);
        System.arraycopy(in,0,leftIn,0,rootId);
        System.arraycopy(in,rootId+1,rightIn,0,pre.length-1-rootId);
        head.left=reConstructBinaryTree1(leftPre,leftIn);
        head.right=reConstructBinaryTree1(rightPre,rightIn);
        return head;
    }
    //通过中序遍历和后序遍历重构二叉树
    public static TreeNode reConstructBinaryTree2(int [] in,int [] post) {
        if(in.length==0){
            return null;
        }
        int root=post[post.length-1];
        int rootId=0;
        for (int i=0;i<in.length;i++){
            if(in[i]==root){
                rootId=i;
                break;
            }
        }
        int[] leftIn=new int[rootId];
        int[] rightIn=new int[in.length-1-rootId];
        int[] leftPost=new int[rootId];
        int[] rightPost=new int[in.length-1-rootId];
        System.arraycopy(in,0,leftIn,0,rootId);
        System.arraycopy(in,rootId+1,rightIn,0,in.length-1-rootId);
        System.arraycopy(post,0,leftPost,0,rootId);
        System.arraycopy(post,rootId,rightPost,0,in.length-1-rootId);
        TreeNode head=new TreeNode(root);
        head.left=reConstructBinaryTree2(leftIn,leftPost);
        head.right=reConstructBinaryTree2(rightIn,rightPost);
        return head;
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

    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode t=reConstructBinaryTree1(pre,in);
        inOrderTraverse2(t);
        System.out.println();
        postOrderTraverse2(t);
        System.out.println();
        levelOrderTraverse(t);
        System.out.println();

        int[] ins={9,3,15,20,7};
        int[] post={9,15,7,20,3};
        TreeNode s=reConstructBinaryTree2(ins,post);
        inOrderTraverse2(s);
        System.out.println();
        postOrderTraverse2(s);
        System.out.println();
        levelOrderTraverse(s);
        System.out.println();
    }


}
