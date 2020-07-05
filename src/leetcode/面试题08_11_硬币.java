package leetcode;

import java.util.Arrays;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题08_11_硬币 {
    public static int waysToChange(int n) {
        int[] coins=new int[]{1,5,10,25};
        int[][] dp=new int[coins.length][n+1];
        Arrays.fill(dp[0],1);
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=n;j++){
                long sum=0;
                int times=j/coins[i];
                for(int k=0;k<=times;k++){
                    sum=(sum+dp[i-1][j-k*coins[i]])%1000000007;
                }
                dp[i][j]=(int)sum%1000000007;
            }
        }
        return dp[coins.length-1][n]%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(100000));
    }
}
