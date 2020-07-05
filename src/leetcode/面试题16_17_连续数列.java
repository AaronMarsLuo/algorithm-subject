package leetcode;

/**
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题16_17_连续数列 {
    public static int maxSubArray(int[] nums) {
        int n=nums.length;
        //int[] dp=new int[];
        int value=Integer.MIN_VALUE;
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(value<0){
                value=nums[i];
            }else{
                value+=nums[i];
            }
            maxValue=Math.max(maxValue,value);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        int[] arr1=new int[]{-5,-6,-4,-2,-1};
        System.out.println(maxSubArray(arr1));
    }
}
