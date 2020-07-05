package 剑指offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int i=0;
        int j=array.length-1;
        int mid=i+(j-i)/2;
        while(j-i>1){
            if(array[j]>array[mid]){
                j=mid;
            } else{
                i=mid;
            }
            mid=i+(j-i)/2;
        }
        return Math.min(array[i],array[j]);
    }

    public static void main(String[] args) {
        int[] arr1=new int[]{1,2,3,4,5,6,7};
        int[] arr2=new int[]{3,4,5,6,7,1,2};
        int[] arr3=new int[]{5,6,7,1,2,3,4};
        System.out.println(minNumberInRotateArray(arr1));
        System.out.println(minNumberInRotateArray(arr2));
        System.out.println(minNumberInRotateArray(arr3));
    }
}
