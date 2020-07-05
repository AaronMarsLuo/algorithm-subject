package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> strMap=new HashMap<>();
        int[] count=new int[26];
        for (String str:strs){
            Arrays.fill(count,0);
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<count.length;i++){
                stringBuilder.append(count[i]);
                stringBuilder.append("#");
            }
            String countStr=stringBuilder.toString();
            if(strMap.containsKey(countStr)){
                strMap.get(countStr).add(str);
            }else{
                List<String> list=new ArrayList<String>(){{
                    add(str);
                }};
                strMap.put(countStr,list);
            }
        }
        return new ArrayList(strMap.values());
    }
}
