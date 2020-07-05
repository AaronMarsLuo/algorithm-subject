package leetcode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que538_把二叉搜索树转换为累加树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(null!=root){
            convertBST(root.right);
            root.val+=sum;
            sum=root.val;
            convertBST(root.left);
        }
        return root;
    }
    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> L=new Stack<>();
        if(null==root){
            return null;
        }
        TreeNode now=root;
        int sum=0;
        while(null!=now || !L.isEmpty()){
            if(null!=now){
                L.push(now);
                now=now.right;
            } else {
                TreeNode top=L.pop();
                top.val+=sum;
                sum=top.val;
                now=top.left;
            }
        }
        return root;
    }

}
