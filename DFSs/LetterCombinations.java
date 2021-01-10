package DFSs;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        String[] s = new String[digits.length()];
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        //先把每个出现的字母对应的字符组合都存入一个字符串数组中：s[]
        for(int i = 0; i < s.length; i++) {
            if(digits.charAt(i) == '2') s[i] = "abc";
            if(digits.charAt(i) == '3') s[i] = "def";
            if(digits.charAt(i) == '4') s[i] = "ghi";
            if(digits.charAt(i) == '5') s[i] = "jkl";
            if(digits.charAt(i) == '6') s[i] = "mno";
            if(digits.charAt(i) == '7') s[i] = "pqrs";
            if(digits.charAt(i) == '8') s[i] = "tuv";
            if(digits.charAt(i) == '9') s[i] = "wxyz";
        }
        //System.out.println(s[0]);
        res = Combine(s, res, 0, "");
        return res;
    }

    /*
    递归，index代表的是s[]中的索引，temp是当前回合的字符
     */
    /**
     *
     * @param s 所有出现的字符组合
     * @param res 结果
     * @param index 当前遍历到的字符组合的索引
     * @param temp 记录当前组成的字符串
     * @return
     */
    public static List<String> Combine(String[] s, List<String> res, int index, String temp) {
        //当遍历最后一个之前的组合时
        if(index < s.length - 1) {
            for(int j = 0; j < s[index].length(); j++) {
                //System.out.println(s[index].charAt(j));
                //将记录的字符串加上当前组合的每个字符。然后index++，进入下个字符组合
                Combine(s, res, index + 1, temp + s[index].charAt(j));
            }
        }
        //当遍历到最后一个组合时，直接依次将每个字符添加到最后
        else {
            for(int j = 0; j < s[index].length(); j++) {
                res.add(temp + s[index].charAt(j));
            }
        }
        return res;
    }
}
