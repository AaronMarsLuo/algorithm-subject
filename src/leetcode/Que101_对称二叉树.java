package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que101_对称二叉树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        treeNodeQueue.add(root);
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            TreeNode p=treeNodeQueue.poll();
            TreeNode q=treeNodeQueue.poll();
            if(null==p && null==q){
                continue;
            }
            if(null==p || null==q){
                return false;
            }
            if(p.val!=q.val){
                return false;
            }
            treeNodeQueue.add(p.left);
            treeNodeQueue.add(q.right);
            treeNodeQueue.add(p.right);
            treeNodeQueue.add(q.left);
        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root) {
        return validate(root,root);
    }
    public boolean validate(TreeNode t1,TreeNode t2){
        if(null==t1 && null==t2){
            return true;
        }
        if(null==t1 || null==t2){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return validate(t1.left,t2.right) && validate(t1.right,t2.left);
    }
}
