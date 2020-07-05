package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树的镜像 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    //递归法求二叉树镜像
    public static void Mirror(TreeNode root) {
        if(null==root){
            return;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
    //非递归法求二叉树镜像
    public static void Mirror1(TreeNode root){
        Queue<TreeNode> L=new LinkedList<>();
        if(null==root){
            return;
        }
        L.add(root);
        while (!L.isEmpty()){
            TreeNode now=L.remove();
            TreeNode tmp=now.left;
            now.left=now.right;
            now.right=tmp;
            if(null!=now.left){
                L.add(now.left);
            }
            if(null!=now.right){
                L.add(now.right);
            }
        }

    }

    //通过中序遍历和后序遍历重构二叉树
    public static TreeNode reConstructBinaryTree2(int [] in, int [] post) {
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
        TreeNode t=reConstructBinaryTree2(new int[]{5,7,2,1,8,4,3,6},new int[]{7,5,2,8,4,6,3,1});
        Mirror(t);
        inOrderTraverse2(t);
        System.out.println();
        postOrderTraverse2(t);
        System.out.println();
        TreeNode s=reConstructBinaryTree2(new int[]{5,7,2,1,8,4,3,6},new int[]{7,5,2,8,4,6,3,1});
        Mirror1(s);
        System.out.println("----------------------------------------------");
        inOrderTraverse2(s);
        System.out.println();
        postOrderTraverse2(s);
        System.out.println();
    }

}
