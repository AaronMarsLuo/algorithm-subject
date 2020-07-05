package leetcode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que31_下一个排列 {
    public static void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }
        if(i>=0){
            for(int j=nums.length-1;j>=0;j--){
                if(nums[j]>nums[i]){
                    int t=nums[i];
                    nums[i]=nums[j];
                    nums[j]=t;
                    break;
                }
            }
        }
        Arrays.sort(nums,i+1,nums.length);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,2};
        nextPermutation(arr);
    }
}
