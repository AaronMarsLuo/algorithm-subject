package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que53_最大子序和 {
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=nums[0];
        for (int i=0;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
            if(sum>maxSum){
                maxSum=sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1={1,-2,3,10,-4,7,2,-5};
        int[] nums2={0,0,0,0,0,-2};
        int[] nums3={-2,-5,-1,-7};
        int[] nums4={-2,-5,0,-7};
        int[] nums5={-2};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
        System.out.println(maxSubArray(nums5));
    }
}
