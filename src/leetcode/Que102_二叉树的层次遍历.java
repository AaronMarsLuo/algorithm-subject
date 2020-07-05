package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que102_二叉树的层次遍历 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> level=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(null==root){
            return level;
        }
        q.add(root);
        q.add(null);
        List<Integer> eachLevel=new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode t=q.poll();
            if(null==t){
                level.add(new ArrayList<>(eachLevel));
                eachLevel.clear();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }else{
                if(null!=t.left){
                    q.add(t.left);
                }
                if(null!=t.right){
                    q.add(t.right);
                }
                eachLevel.add(t.val);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.right.left=new TreeNode(3);
        t.right.right = new TreeNode(6);
        List<List<Integer>> L=levelOrder(t);
        for (List<Integer> i:L){
            System.out.println(i);
        }
    }
}
