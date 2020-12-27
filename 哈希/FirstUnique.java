package 哈希;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FirstUnique {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar("qwweerrtyytq"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        //用字典存储每个字符出现次数
        for(char cc : c) {
            map.put(cc, map.getOrDefault(cc, 0) + 1);
        }
        //依次遍历字符串，返回第一个出现次数为一的字符
        for(int i = 0; i < c.length; i++) {
            if(map.get(c[i]) == 1) return i;
        }
        //若没有次数为一的返回-1
        return -1;
    }
}
