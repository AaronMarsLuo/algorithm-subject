package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que22_括号生成 {
    static List<String> allOrder = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        getBracket("",n,n);
        return allOrder;
    }

    public static void getBracket(String order, int left, int right) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            allOrder.add(order);
            return;
        }
        if (left > 0) {
            getBracket(order + "(", left - 1, right);
        }
        if (right > 0) {
            getBracket(order + ")", left, right - 1);
        }

    }

    public static void main(String[] args) {
        List<String> L=generateParenthesis(3);
        for (String i:L){
            System.out.println(i);
        }
    }
}
