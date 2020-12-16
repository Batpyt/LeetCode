package 哈希;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

    /*
    用map来对应pattern和字符串
     */
    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        char[] c = pattern.toCharArray();
        String[] sc = s.split(" ");
        if(c.length != sc.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < c.length; i++) {
            //若map中已经存在该pattern，判断是否对应相同的字符串
            if(map.containsKey(c[i])) {
                //如果对应的字符串不同，返回false
                if(!sc[i].equals(map.get(c[i]))) return false;
            }
            //若不存在该pattern
            else {
                //如果对应字符串已存在，也返回false
                if(map.containsValue(sc[i])) return false;
                else map.put(c[i], sc[i]);
            }
        }
        return true;
    }
}
