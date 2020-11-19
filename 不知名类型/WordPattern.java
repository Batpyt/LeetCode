package 不知名类型;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WordPattern {
    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern,s));
    }


    /*
    用map记录对应关系。pattern中的字符为key，s中的字符串为value。
     */
    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        String[] str = s.split(" ");
        if(pattern.length() != str.length) return false;
        HashMap<Character,String> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            //当map中有key
            if(map.containsKey(c)) {
                //如果key的值不一样则返回false
                if(!map.get(c).equals(str[i])) return false;
            }
            //当map中没有key
            else {
                //如果value已经存在，key却不一样，返回false
                if(map.containsValue(str[i])) return false;
                //否则新添加一个k-v值
                else map.put(c, str[i]);
            }
        }
        return true;
    }
}
