package 动态规划;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SubStringContainThreeContain {
    public static void main(String[] args) {
        String s = "abcabc";
        SubStringContainThreeContain sub = new SubStringContainThreeContain();
        System.out.println(sub.numberOfSubstrings(s));
    }

    /**
     * 规划一个窗口。
     * 当窗口内的字符串符合标准时，窗口右边的所有字符串都符合条件
     */
    public int numberOfSubstrings(String s) {
        int left = 0;//窗口左边
        int[] flag = new int[3];//用来记录窗口中abc个数的数组
        int count = 0;

        for(int right = 0; right < s.length(); right++) {//窗口右边，每次右移
            //窗口最右边的字符，也是新加进来的字符
            char charright = s.charAt(right);
            //将该字符记录
            flag[charright - 'a']++;
            //当三个字符都存在时，计算右边还有多少字符并计算结果
            while(flag[0] > 0 && flag[1] > 0 && flag[2] > 0) {
                //窗口右边所剩余的字符串可能性都符合条件
                count = count + s.length() - right;
                //窗口左边的字符，也就是即将从窗口移除的
                char charleft = s.charAt(left);
                //将该字符的记录删除
                flag[charleft - 'a']--;
                //窗口左移
                left++;
            }
        }
        return count;
    }
}
