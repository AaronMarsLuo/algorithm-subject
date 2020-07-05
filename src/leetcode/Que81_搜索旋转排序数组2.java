package leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que81_搜索旋转排序数组2 {
    public boolean search(int[] nums, int target) {
        if(null==nums){
            return false;
        }
        int i=0,j=nums.length-1;
        int mid=i+(j-i)/2;
        while(i<=j){
            if(nums[mid]==target){
                return true;
            }
            if(nums[i]>nums[mid]){
                if(target>nums[mid] && target<nums[i]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }else if(nums[i]<nums[mid]){
                if(target>=nums[i] && target<nums[mid]){
                    j=mid-1;
                }else {
                    i=mid+1;
                }
            }else{
                i++;
            }
            mid=i+(j-i)/2;
        }
        return false;
    }
}
