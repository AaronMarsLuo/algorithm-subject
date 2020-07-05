package leetcode;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class 面试题19_正则表达式匹配 {
    public static boolean isMatch1(String s, String p) {
        if(s.length()==0 && p.length()!=0){
            if(p.length()%2==1){
                return false;
            }
            for(int i=0;i<p.length()-1;i+=2){
                if(p.charAt(i+1)!='*'){
                    return false;
                }
            }
            return true;
        }
        int i = 0, j = 0;
        char now = ' ';
        while (i < s.length() && j < p.length()) {
            if(j<p.length()-1 && p.charAt(j+1)=='*'){
                while(i<s.length() && (p.charAt(j)=='.' ||s.charAt(i)==p.charAt(j))){
                    i++;
                }
                j+=2;
                continue;
            }
            if(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else{
                return false;
            }
        }
        return i==s.length() && j==p.length();
    }
    public static boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()!=0){
            return checkString(p);
        }
        int i = s.length()-1, j = p.length()-1;
        while (i>=0 && j >=0) {
            if(j>0 && p.charAt(j)=='*'){
                while(i>=0 && (p.charAt(j-1)=='.' || s.charAt(i)==p.charAt(j-1))){
                    i--;
                }
                j-=2;
                continue;
            }
            if(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)){
                i--;
                j--;
            }else{
                return false;
            }
        }
        return i==-1 && (j==-1 || checkString(p.substring(0,j+1)));
    }
    public static boolean checkString(String str){
        if(str.length()==0){
            return true;
        }
        if(str.length()%2==1){
            return false;
        }
        for(int i=1;i<str.length();i+=2){
            if(str.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("tellme".substring(0,2));
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("sdafsd","s.*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("mississippi","mis*is*p*."));
        System.out.println(isMatch("","abc"));
        System.out.println(isMatch("","c*a*b*"));
        System.out.println(isMatch("aab",""));
        System.out.println(isMatch("",""));
        System.out.println(isMatch("abb",".*c"));
        System.out.println(isMatch("aaa","a*a"));
        System.out.println(isMatch("aaa","a*aaaa"));
    }
}
