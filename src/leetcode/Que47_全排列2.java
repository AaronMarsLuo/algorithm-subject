package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que47_全排列2 {
    static List<List<Integer>> res= new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Boolean[] isChosen=new Boolean[nums.length];
        Arrays.fill(isChosen,false);
        List<Integer> numIndex=new ArrayList<>();
        generateSeq(nums,isChosen,numIndex);
        return res;
    }
    public static void generateSeq(int[] nums,Boolean[] isChosen,List<Integer> numIndex){
        if(numIndex.size()==nums.length){
            List<Integer> list=new ArrayList<>(numIndex);
            res.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isChosen[i]){
                if(i>0 && nums[i]==nums[i-1] && !isChosen[i-1]){
                    continue;
                }
                isChosen[i]=true;
                numIndex.add(nums[i]);
                generateSeq(nums,isChosen,numIndex);
                isChosen[i]=false;
                int len=numIndex.size();
                numIndex.remove(len-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> L=permuteUnique(new int[]{2,1,1,3});
        for (List<Integer> i:L
             ) {
            System.out.println(i);
        }
    }
}
