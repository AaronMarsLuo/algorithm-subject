package leetcode;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import 剑指offer.二叉树遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que94_二叉树的中序遍历 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    static List<Integer> order=new ArrayList<>();
    public static List<Integer> inorderTraversal1(TreeNode root) {
       getOrder(root);
       return order;
    }
    public static void getOrder(TreeNode root){
        if(null!=root){
            getOrder(root.left);
            order.add(root.val);
            getOrder(root.right);
        }
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode now=root;
        while(null!=now || !stack.isEmpty()){

            if(null!=now){
                stack.push(now);
                now=now.left;
            }else {
                list.add(stack.peek().val);
                now=stack.pop().right;
            }
        }
        return list;
    }
    public static void print(List<Integer> list){
        for (Integer i:list) {
            System.out.print(i+" ");
        }
        System.out.println();
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
        print(inorderTraversal1(t));
        print(inorderTraversal2(t));
    }
}
