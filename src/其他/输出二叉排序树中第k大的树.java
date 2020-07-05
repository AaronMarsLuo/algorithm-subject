package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class 输出二叉排序树中第k大的树 {
    private int num;

    class Node {
        Node left;
        Node right;
        int val;
    }

    public void kthNode(Node root, int k) {
        num = k;
        myOrderReverse(root);
    }

    private void myOrderReverse(Node root) {
        if (num <= 0) {
            return;
        }
        if (null == root) {
            return;
        }
        myOrderReverse(root.right);
        num--;
        if (num == 0) {
            System.out.println(root.val);
        }
        myOrderReverse(root.left);
    }

    public static void main(String[] args) {
//        CopyOnWriteArrayList<Integer> copyList=new CopyOnWriteArrayList<>();
//        copyList.add(1);
//        copyList.add(2);
//        copyList.add(3);
//
//        for (Integer integer : copyList) {
//            System.out.println(copyList.size());
//            if(integer==2){
//                copyList.remove(integer);
//            }
//        }

        Integer[] arr=new Integer[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        Integer[] des=new Integer[3];
        System.arraycopy(arr,0,des,0,3);
        System.out.println(Arrays.toString(des));
        des[0]=5;
        System.out.println(Arrays.toString(arr));
        Integer[] des3=Arrays.copyOf(arr,arr.length+3);
        System.out.println(Arrays.toString(des3));
        arr[0]=999;
        System.out.println(Arrays.toString(des3));
        String[] str1=new String[]{"a","b","c"};
        String[] str2=new String[3];
        System.arraycopy(str1,0,str2,0,3);
        System.out.println(Arrays.toString(str2));
        str1[0]="d";
        System.out.println(Arrays.toString(str2));
        String[] str3=Arrays.copyOf(str1,4);
        System.out.println(Arrays.toString(str3));
        str1[0]="e";
        System.out.println(Arrays.toString(str3));
    }

}
