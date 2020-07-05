package leetcode;

public class Que226_翻转二叉树 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public TreeNode invertTree(TreeNode root) {
        if(null!=root){
            TreeNode t=root.left;
            root.left=root.right;
            root.right=t;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
