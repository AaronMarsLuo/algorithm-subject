package leetcode;

import java.util.Collections;
import java.util.Objects;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que14_最长公共前缀 {

    //我的想法
    public static String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length <= 0) {
            return "";
        }
        String flag = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int m = flag.length();
            int n = strs[i].length();
            int len = m > n ? n : m;
            flag = flag.substring(0, len);
            if (len == 0) {
                break;
            }
            for (int j = 0; j < len; j++) {
                if (flag.charAt(j) != strs[i].charAt(j)) {
                    flag = flag.substring(0, j);
                    break;
                }
            }
        }
        return flag;
    }

    //改进
    public static String longestCommonPrefix1(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char p = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || p != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    //改进，二分查找法
    public static String longestCommonPrefix2(String[] strs){
        if(null==strs || strs.length==0){
            return "";
        }
        int mixLen=strs[0].length();
        for (String s:strs) {
            if (s.length()<mixLen){
                mixLen=s.length();
            }
        }
        int start=0;
        int end=mixLen-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(vertifyPrefix(strs,mid)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return strs[0].substring(0,(start+end+2)/2);
    }
    public static boolean vertifyPrefix(String[] strs,int len){
        String str=strs[0].substring(0,len+1);
        for(int i=1;i<strs.length;i++){
            if(!strs[i].substring(0,len+1).equals(str)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix2(new String[]{"aa", "a"}));
        System.out.println(longestCommonPrefix2(new String[]{"a", "aa"}));
        System.out.println(longestCommonPrefix2(new String[]{"", "aa"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog", ""}));
        System.out.println(longestCommonPrefix2(new String[]{"dog"}));
        System.out.println(longestCommonPrefix2(new String[]{""}));
        System.out.println(longestCommonPrefix2(new String[]{}));
    }
}
