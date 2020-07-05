package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> l=new ArrayList<>();
        calculatePath(root,target,l);
        return list;
    }
    public static void calculatePath(TreeNode root,int target,ArrayList<Integer> l){
        if(null==root){
            return;
        }
        l.add(root.val);
        if(null==root.left && null==root.right){
            if(target-root.val==0){
                list.add(new ArrayList<>(l));
            }
            l.remove(l.size()-1);
            return;
        }
        calculatePath(root.left,target-root.val,l);
        calculatePath(root.right,target-root.val,l);
        l.remove(l.size()-1);
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(10);
        head.left=new TreeNode(5);
        head.left.left=new TreeNode(7);
        head.left.right=new TreeNode(4);
        head.right=new TreeNode(12);
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(head, 22);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList.toString());
        }

    }
}
