package 不知名类型;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> word = new LinkedList<>();
        word.add("leet");
        word.add("code");
        System.out.println(wordBreak(s, word));
    }

    /*
    动态规划
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        //维护一个数组，dp[i]代表着s[i-1]结尾的字符串能否被wordDict拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            //从j遍历到i。
            for(int j = 0; j < i; j++) {
                //每次截取字符串s[j,i]，若字符串在wordDict中，且s[j-1]能被分割，表示i-1也能被分割
                //因此将dp[i-1]记录为true
                if(wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //若最终最后一位也是true说明字符串s可以被拆分
        return dp[s.length()];
    }
}
