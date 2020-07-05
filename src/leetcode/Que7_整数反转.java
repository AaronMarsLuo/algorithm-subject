package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123 输出: 321  示例 2:
 * <p>
 * 输入: -123 输出: -321 示例 3:
 * <p>
 * 输入: 120 输出: 21 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que7_整数反转 {

    //我想到的方法
    public static int reverse(int x) {
        int num = Math.abs(x);
        List<Integer> L = new ArrayList<>();
        while (num != 0) {
            int remainder = num % 10;
            num = num / 10;
            L.add(remainder);
        }
        long returnNum = 0;
        for (int i = 0; i < L.size(); i++) {
            returnNum += L.get(i) * Math.pow(10, L.size() - i - 1);
        }
        if (x < 0) {
            returnNum *= -1;
        }
        if (returnNum > Math.pow(2, 31) - 1 || returnNum < Math.pow(2, 31) * -1) {
            return 0;
        }
        return (int) returnNum;
    }

    //改进的方法
    public static int reverse1(int x) {
        StringBuilder str = new StringBuilder();
        if (x < 0) {
            str.append("-");
        }
        try {
            return Integer.parseInt(
                    str.toString() + new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    //改进方法2
    public static int reverse2(int x) {
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if ((pop > 0 && reverse > (Integer.MAX_VALUE - pop) / 10) || (pop < 0
                    && reverse < (Integer.MIN_VALUE - pop) / 10)) {
                return 0;
            }
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse1(1534236469));
        System.out.println(reverse2(-1534236469));
    }
}
