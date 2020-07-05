package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Qur448_找到所有数组中消失的数字 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> L=new ArrayList<>();
        if(null==nums || nums.length<2){
            return L;
        }
        for(int i=0;i<nums.length;i++){
            int t=Math.abs(nums[i]);
            nums[t-1]=-1*Math.abs(nums[t-1]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                L.add(i+1);
            }
        }
        return L;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
