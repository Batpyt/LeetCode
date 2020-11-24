package 动态规划;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }

    /*
    滑动窗口，先记录前n位s的字符出现次数和p的出现次数
    然后每次往后移一位，删除最前前面的，加上后面的，如果记录出现次数的数组相等便记录
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(s.length() < p.length()) return res;
        int[] counts = new int[26];
        int[] countp = new int[26];
        int index = 0;
        //记录起始几位的字符出现次数
        for(char c : p.toCharArray()) {
            countp[c - 'a']++;
            counts[s.charAt(index) - 'a']++;
            index++;
        }
        //先对比出现次数是否相等，若相等记录0
        if(Arrays.equals(counts, countp)) {
            res.add(0);
        }
//        for(int i = 0; i < countp.length; i++) {
//            System.out.println(counts[i] +" "+countp[i]);
//        }

        index = 0;
        //从index = 0开始滑动窗口，减去index位置字符的出现次数，加上新加入的字符，对比
        for(int i = p.length(); i < s.length(); i++) {
            counts[s.charAt(index) - 'a']--;
            counts[s.charAt(i) - 'a']++;
            index++;
            if(Arrays.equals(counts, countp)) res.add(index);
        }
        return res;
    }
}
