package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121 输出: true 示例 2:
 * <p>
 * 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。 示例 3:
 * <p>
 * 输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que9_回文数 {

    //我的解法
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int reverse = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            if ((Integer.MAX_VALUE - pop) / 10 < reverse) {
                return false;
            }
            reverse = reverse * 10 + pop;
        }
        return reverse == x;
    }

    //优化，只需要反转一半就可以
    public static boolean isPalindrome1(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int num = x;
        int reverse = 0;
        while (reverse < num) {
            int pop = num % 10;
            num /= 10;
            if ((Integer.MAX_VALUE - pop) / 10 < reverse) {
                return false;
            }
            reverse = reverse * 10 + pop;
        }
        return (reverse == num) || (reverse / 10 == num);
    }

    public static void main(String[] args) {
        int[] nums1 = null;
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(456654));
        System.out.println(isPalindrome(43534));
        System.out.println(isPalindrome(-12321));
    }
}
