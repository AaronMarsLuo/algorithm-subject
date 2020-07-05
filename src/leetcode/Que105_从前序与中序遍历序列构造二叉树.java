package leetcode;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que105_从前序与中序遍历序列构造二叉树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null==preorder || preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        int rootId=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                rootId=i;
                break;
            }
        }
        if (preorder.length==1){
            return root;
        }
        int[] preOrderLeft=new int[rootId];
        int[] inOrderLeft=new int[rootId];
        int[] preOrderRight=new int[inorder.length-1-rootId];
        int[] inOrderRight=new int[inorder.length-1-rootId];
        System.arraycopy(preorder,1,preOrderLeft,0,rootId);
        System.arraycopy(inorder,0,inOrderLeft,0,rootId);
        System.arraycopy(preorder,rootId+1,preOrderRight,0,inorder.length-1-rootId);
        System.arraycopy(inorder,rootId+1,inOrderRight,0,inorder.length-1-rootId);
        root.left=buildTree(preOrderLeft,inOrderLeft);
        root.right=buildTree(preOrderRight,inOrderRight);
        return root;
    }
}
