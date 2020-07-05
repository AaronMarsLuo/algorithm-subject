package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que17_电话号码的字母组合 {
     static Map<String,String> phone=new HashMap<String,String>(){{
         put("2","abc");put("3","def");put("4","ghi");
         put("5","jkl");put("6","mno");put("7","pqrs");
         put("8","tuv");put("9","wxyz");
     }};
     static List<String> out=new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if(null==digits || digits.equals("")){
            return out;
        }
        reflect("",digits);
        return out;
    }
    public  static void reflect(String now,String next){
        if(next.equals("")){
            out.add(now);
            return;
        }
        String key=String.valueOf(next.charAt(0));
        String rest=next.length()>1?next.substring(1):"";
        String letters=phone.get(key);
        for (int i=0;i<letters.length();i++){
            reflect(now+String.valueOf(letters.charAt(i)),rest);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}

