package 剑指offer;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 替换空格 {
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char t=str.charAt(i);
            if(t==' '){
                sb.append("%20");
            }else{
                sb.append(t);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("abc sd ");
        System.out.println(replaceSpace(sb));
    }
}
