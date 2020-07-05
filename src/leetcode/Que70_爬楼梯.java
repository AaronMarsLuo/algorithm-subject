package leetcode;

import java.util.Stack;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que70_爬楼梯 {
    public static int climbStairs(int n) {
        if(n<3) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    public static int climbStairs1(int n) {
        if(n<3) return n;
        int p=1,q=2;
        while (n-3>=0){
            int sum=p+q;
            n--;
            p=q;
            q=sum;
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs1(1));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs1(4));
        System.out.println(climbStairs1(5));
    }
}
