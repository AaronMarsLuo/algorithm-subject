package leetcode;

/**
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que153_寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        int i=0,j=nums.length-1;
        int mid=i+(j-i)/2;
        int min=nums[0];
        while(i<=j){
            if(nums[i]<nums[mid]){
                min=Math.min(min,nums[i]);
                i=mid+1;
            }else if(nums[i]>nums[mid]){
                min=Math.min(min,nums[mid]);
                j=mid-1;
            }else{
                min=Math.min(min,nums[mid]);
                i++;
            }
            mid=i+(j-i)/2;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,1}));
    }
}
