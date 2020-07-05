package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode now=root;
        queue.add(root);
        while(!queue.isEmpty()){
            now=queue.remove();
            if(null!=now){
                list.add(now.val);
                queue.add(now.left);
                queue.add(now.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(null);
        System.out.println(queue.size());
    }
}
