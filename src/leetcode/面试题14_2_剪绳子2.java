package leetcode;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 */
public class 面试题14_2_剪绳子2 {
    public static int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        int t=n/3;
        int mod=n%3;
        if(mod==0){
            return calculate(3,t,1);
        }else if(mod==2){
            return calculate(3,t,2);
        }else if(mod==1){
            return calculate(3,t-1,3);
        }
        return 1;
    }
    public static int calculate(int a,int b,int op){
        long ans=1;
        for(int i=0;i<b;i++){
            ans=(long)((ans*a)%(1e9+7));
        }
        if(op==2){
            ans=(long)((ans*2)%(1e9+7));
        }else if(op==3){
            ans=(long)((ans*4)%(1e9+7));
        }
        return (int)ans;
    }
    public static int calculate1(int a,int b,int op){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }
}
