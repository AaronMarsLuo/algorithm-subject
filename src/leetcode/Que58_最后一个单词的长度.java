package leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que58_最后一个单词的长度 {
    public static int lengthOfLastWord(String s) {
        if(null==s || s.length()==0){
            return 0;
        }
        int count=0;
        boolean emptyEndCheck=true;
        for(int i=s.length()-1;i>=0;i--){
            char t=s.charAt(i);
            if(emptyEndCheck && t!=' '){
                emptyEndCheck=false;
            }
            if(!emptyEndCheck){
                if(t==' '){
                    break;
                }else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("hello world "));
        System.out.println(lengthOfLastWord("world"));
        System.out.println(lengthOfLastWord(" "));
    }
}
