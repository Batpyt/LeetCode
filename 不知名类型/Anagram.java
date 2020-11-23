package 不知名类型;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    /**
     * 创建一个char数组来统计每个字符出现次数。遍历s++，遍历t--，若有不等于0的就返回false
     */
    public static boolean isAnagram(String s, String t) {
        char[] cs = new char[58];
        //char[] ct = new char[58];

        for(char c : s.toCharArray()) {
            cs[c - 'A']++;
        }

        for(char c : t.toCharArray()) {
            cs[c - 'A']--;
        }

        for(int i = 0; i < cs.length; i++) {
            if(cs[i] != 0) return false;
        }

        return true;
    }
}
