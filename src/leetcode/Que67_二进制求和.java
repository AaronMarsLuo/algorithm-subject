package leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que67_二进制求和 {
    public static String addBinary(String a, String b) {
        int len=Math.max(a.length(),b.length());
        StringBuilder textA=new StringBuilder(a);
        StringBuilder textB=new StringBuilder(b);
        for(int i=0;i<len-a.length()+1;i++){
            textA.insert(0,'0');
        }
        for (int i=0;i<len-b.length()+1;i++){
            textB.insert(0,'0');
        }
        StringBuilder textC=new StringBuilder();
        int t=0;
        for(int i=textA.length()-1;i>=0;i--){
            int p=textA.charAt(i)-'0';
            int q=textB.charAt(i)-'0';
            int sum=p^q^t;
            if(p+q+t>=2){
                t=1;
            }else{
                t=0;
            }
            textC.insert(0,sum);
        }
        if(textC.charAt(0)=='0'){
            return textC.substring(1);
        }
        return textC.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("0","0"));
    }
}
