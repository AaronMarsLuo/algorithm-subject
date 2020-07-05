package leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que98_验证二叉搜索树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public static boolean isValidBST1(TreeNode root) {
        if(null!=root){
            boolean islegal=(null==root.left || root.val>root.left.val) && (null==root.right || root.val<root.right.val);
            return  islegal&& isValidBST1(root.left)&&isValidBST1(root.right);
        }
        return true;
    }
    public static boolean isValidBST2(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean validate(TreeNode t,long min,long max){
        if(null!=t){
            if(t.val<=min || t.val>=max){
                return false;
            }
            return validate(t.left,min,t.val) && validate(t.right,t.val,max);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.right.left=new TreeNode(3);
        t.right.right = new TreeNode(6);
        System.out.println(isValidBST1(t));
    }
}
