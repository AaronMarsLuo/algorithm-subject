package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution=new ArrayList<>();
        if(null==nums || nums.length<3){
            return solution;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int j=i+1,k=nums.length-1;
                while(j<k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        solution.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1]){
                            j++;
                        }
                        while (k>j && nums[k]==nums[k-1]){
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum > 0) {
                        while (k>j && nums[k]==nums[k-1]){
                            k--;
                        }
                        k--;
                    } else {
                        while(j<k && nums[j]==nums[j+1]){
                            j++;
                        }
                        j++;
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {

    }
}
