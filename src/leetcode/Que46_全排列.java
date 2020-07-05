package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que46_全排列 {
    static List<List<Integer>> allSeq=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        Boolean[] isNumsChosen=new Boolean[nums.length];
        for (int i=0;i<isNumsChosen.length;i++){
            isNumsChosen[i]=false;
        }
        List<Integer> numsIndex=new ArrayList();
        generateSeq(nums,isNumsChosen,numsIndex);
        return allSeq;
    }
    public static void generateSeq(int[] nums,Boolean[] isNumsChosen,List<Integer> numsIndex){
        if(numsIndex.size()==nums.length){
            List<Integer> list=new ArrayList<>(numsIndex);
            allSeq.add(list);
            return;
        }
        for(int i=0;i<isNumsChosen.length;i++){
            if(!isNumsChosen[i]){
                isNumsChosen[i]=true;
                numsIndex.add(nums[i]);
                generateSeq(nums,isNumsChosen,numsIndex);
                isNumsChosen[i]=false;
                int len=numsIndex.size();
                numsIndex.remove(len-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result=permute(new int[]{4,1,2,3});
        for (List<Integer> i:result) {
            for (Integer j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
