package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()" 输出: true 示例 2:
 * <p>
 * 输入: "()[]{}" 输出: true 示例 3:
 * <p>
 * 输入: "(]" 输出: false 示例 4:
 * <p>
 * 输入: "([)]" 输出: false 示例 5:
 * <p>
 * 输入: "{[]}" 输出: true
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que20_有效的括号 {

    //我的想法
    public static boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> L = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '{' || p == '[' || p == '(') {
                L.push(p);
            } else {
                if (L.empty()) {
                    return false;
                }
                char q = L.peek();
                if ((q == '{' && p == '}') || (q == '[' && p == ']') || (q == '(' && p == ')')) {
                    L.pop();
                } else {
                    return false;
                }
            }
        }
        if (L.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid(""));
        System.out.println(isValid("(){}"));
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("){[]"));
        System.out.println(isValid("()[]{"));
        System.out.println(isValid("([([]{}){([{[()]}])[]{}}])"));

    }
}
