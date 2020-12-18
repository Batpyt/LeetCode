package 不知名类型;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Difference {
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        //建立数组来储存每个字符出现次数
        int[] m = new int[26];
        for(char c : s.toCharArray()) {
            m[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            //若在s中没出现过或出现次数减为0了，直接返回
            if(m[c - 'a'] == 0) return c;
            else{
                m[c - 'a']--;
            }
        }
        return 'a';
    }
}
