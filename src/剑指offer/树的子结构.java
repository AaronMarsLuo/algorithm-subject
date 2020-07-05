package 剑指offer;

import java.util.Stack;

public class 树的子结构 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //判断二叉树的子树
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = doesTree1HasTree2(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public static boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        } else if (null != root1 && null != root2) {
            if (root1.val != root2.val) {
                return false;
            }
            return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
        } else {
            return false;
        }
    }
    //--------------------------------------------------------------------------
    public static String inOrderTraverse(TreeNode t){
        StringBuilder str=new StringBuilder();
        Stack<TreeNode> L=new Stack<>();
        TreeNode now=t;
        while (null!=now || !L.isEmpty()){
            if(null!=now){
                L.push(now);
                now=now.left;
            } else {
                now=L.pop();
                str.append(now.val);
                now=now.right;
            }
        }
        return str.toString();
    }


    //--------------------------------------------------------------------------

    //判断是否是二叉树子结构
    public static boolean HasSubstructure(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = doesTree1HasTree2Structure(root1, root2);
        }
        if (!result) {
            result = HasSubstructure(root1.left, root2);
        }
        if (!result) {
            result = HasSubstructure(root1.right, root2);
        }
        return result;
    }

    public static boolean doesTree1HasTree2Structure(TreeNode root1, TreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == root1) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2Structure(root1.left, root2.left) && doesTree1HasTree2Structure(root1.right, root2.right);
    }

    /**      t                   s                p
     *       1                   2                1
     *      /\                  /\               /\
     *     2  3                4 5              2 3
     *    /\  /                   \
     *   4 5 6                    7
     *      \
     *       7
     */

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.left.right.right = new TreeNode(7);
        TreeNode s = new TreeNode(2);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.right.right = new TreeNode(7);
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        System.out.println(HasSubtree(t, s));
        System.out.println(HasSubtree(t, p));
        System.out.println(HasSubstructure(t, s));
        System.out.println(HasSubstructure(t, p));

        System.out.println(inOrderTraverse(t).contains(inOrderTraverse(s)));
        System.out.println(inOrderTraverse(s));
        System.out.println(inOrderTraverse(p));
    }
}
