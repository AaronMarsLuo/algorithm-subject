package 剑指offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int p = 0;
        int q = 1;
        int result = 1;
        while (n - 1 > 0) {
            result = p + q;
            if (p > q) {
                q = result;
            } else {
                p = result;
            }
            n--;
        }
        return result;
    }
}
