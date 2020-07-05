package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que5_最长回文子串 {
    public static String longestPalindrome(String s) {
        StringBuilder str=new StringBuilder();
        str.append('@');
        for(int i=0;i<s.length();i++){
            str.append('#').append(s.charAt(i));
        }
        str.append('#');
        int[] p=new int[str.length()];
        int id=0,mx=0;
        int maxId=0,maxLength=0;
        for (int i=1;i<str.length();i++){
            p[i]=(i<mx)?Math.min(p[2*id-i],mx-i):1;
            while(i+p[i]<str.length() && str.charAt(i+p[i])==str.charAt(i-p[i])){
                p[i]++;
            }
            if(i+p[i]>mx){
                mx=i+p[i];
                id=i;
            }
            if(p[i]>maxLength){
                maxLength=p[i];
                maxId=i;
            }

        }
        int start=(maxId-p[maxId])/2;
        return s.substring(start,start+maxLength-1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("12212321"));
    }
}
