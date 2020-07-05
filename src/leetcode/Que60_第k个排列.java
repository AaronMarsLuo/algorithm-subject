package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que60_第k个排列 {
    public static String getPermutation(int n, int k) {
        k--;
        int[] arr=new int[n];
        int index=0;
        List<Integer> allNums=new ArrayList<>();
        for(int i=0;i<n;i++){
            allNums.add(i+1);
        }
        n--;
        while(k>0){
            int fac=factorial(n);
            int num=k/fac;
            arr[index++]=allNums.get(num);
            k-=(num*fac);
            n--;
            allNums.remove(num);
        }
        for(int i=0;i<allNums.size();i++){
            arr[index++]=allNums.get(i);
        }
        String str= Arrays.toString(arr);
        return str.substring(1,str.length()-1).replaceAll(", ","");
    }
    public static int factorial(int n){
        int sum=1;
        for(int i=1;i<=n;i++){
            sum*=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(5,8));
    }
}
