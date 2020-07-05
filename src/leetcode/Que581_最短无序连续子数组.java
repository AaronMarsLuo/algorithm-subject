package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return 0;
        }
        int left = 0, right = 0;
        for (int k = 0; k < nums.length-1; k++) {
            if (nums[k] > nums[k+1]) {
                left=k;
                break;
            }
        }
        for (int k = nums.length-1; k >0; k--) {
            if(nums[k]<nums[k-1]){
                right=k;
                break;
            }
        }

        if(left==right){//原数组本身就有序了
            return 0;
        }
        int minInZone=Integer.MAX_VALUE,maxInZone= Integer.MIN_VALUE;
        for(int k=left;k<=right;k++){
            if(nums[k]<minInZone){
                minInZone=nums[k];
            }
            if(nums[k]>maxInZone){
                maxInZone=nums[k];
            }
        }
        for(int k=0;k<nums.length;k++){
            if(nums[k]>minInZone){
                left=k;
                break;
            }
        }
        for (int k=nums.length-1;k>=0;k--){
            if(nums[k]<maxInZone){
                right=k;
                break;
            }
        }
        return right-left+1;
    }
}
