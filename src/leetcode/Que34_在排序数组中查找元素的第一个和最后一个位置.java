package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que34_在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int left=searchLeft(nums,target);
        int right=searchRight(nums, target);
        return new int[]{left,right};
    }
    public static int searchLeft(int[] nums,int target){
        int i=0,j=nums.length-1;
        int mid=i+(j-i)/2;
        while(i<=j){
            if (target==nums[mid]){
                j=mid-1;
            }else if(target>nums[mid]){
                i=mid+1;
            }else if(target<nums[mid]){
                j=mid-1;
            }
            mid=i+(j-i)/2;
        }
        if(i==nums.length || nums[i]!=target){
            return -1;
        }
        return i;
    }
    public static int searchRight(int[] nums,int target){
        int i=0,j=nums.length-1;
        int mid=i+(j-i)/2;
        while(i<=j){
            if(target==nums[mid]){
                i=mid+1;
            }else if(target>nums[mid]){
                i=mid+1;
            }else if(target<nums[mid]){
                j=mid-1;
            }
            mid=i+(j-i)/2;
        }
        if(j<0 || nums[j]!=target){
            return -1;
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,2,2,3,4};
        System.out.println(Arrays.toString(searchRange(arr,0)));
        System.out.println(Arrays.toString(searchRange(arr,1)));
        System.out.println(Arrays.toString(searchRange(arr,2)));
        System.out.println(Arrays.toString(searchRange(arr,3)));
        System.out.println(Arrays.toString(searchRange(arr,4)));
        System.out.println(Arrays.toString(searchRange(arr,5)));
    }
}
