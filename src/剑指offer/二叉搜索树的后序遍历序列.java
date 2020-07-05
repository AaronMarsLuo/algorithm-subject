package 剑指offer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class 二叉搜索树的后序遍历序列 {
    //递归方法
    public static boolean VerifySquenceOfBST(int [] sequence) {
       if(sequence.length==0){
           return false;
       }
       return isPostOrder(sequence);
    }
    public static boolean isPostOrder(int[] sequence){
        int len=sequence.length;
        if(len<=1){
            return true;
        }
        int i=0;
        while (sequence[i]<sequence[len-1]){
            i++;
        }
        for(int j=i;j<len-1;j++){
            if(sequence[j]<sequence[len-1]){
                return false;
            }
        }
        int[] leftSequence=new int[i];
        int[] rightSequence=new int[len-i-1];
        System.arraycopy(sequence,0,leftSequence,0,i);
        System.arraycopy(sequence,i,rightSequence,0,len-i-1);
        return isPostOrder(leftSequence) && isPostOrder(rightSequence);
    }
    //非递归方法
    public static boolean VerifySquenceOfBST1(int [] sequence) {
        int len=sequence.length;
        if (len==0){
            return false;
        }
        int i=0;
        while(len>0){
            while(sequence[i]<sequence[len-1]){
                i++;
            }
            while(sequence[i]>sequence[len-1]){
                i++;
            }
            if(i<len-1){
                return false;
            }
            i=0;
            len--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST1(new int[]{0,2,1,5,3,7,9,8,6}));

    }
}
