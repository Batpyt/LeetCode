package 哈希;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TongGouString {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        String s2 = "foo", t2 = "bar";
        System.out.println(isIsomorphic(s2,t2));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();

        /*
        用map，s的字符当作k，t的字符当作v
         */
        for(int i = 0; i < s.length(); i++) {
            //若当前s的字符还没出现过
            if(!map.containsKey(s.charAt(i))) {
                //若t的字符也没出现过，将这对k-v加入map
                if(!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                }
                //若t字符出现过，返回false
                else return false;
            }
            //若当前s字符出现过
            else {
                //若该字符以前对应的v和当前t字符不一致，返回false
                if(map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
