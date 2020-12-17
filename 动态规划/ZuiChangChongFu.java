package 动态规划;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZuiChangChongFu {
    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};

        System.out.println(findLength(a,b));
    }

    /*
       1 2 3 2 1
     3 0 0 1 0 0
     2 0 1 0 2 0
     1 1 0 0 0 3
     4
     7
     */
    public static int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) return 0;
        //dp中储存到该位置为止有多少位相同
        int[][] dp = new int[A.length + 1][B.length + 1];
        int result = 0;

        //若该位置相同，继承dp数组中该位置左上方的值
        //由于第一行第一列没有左上，所以从1开始计数，dp中0行0列都为0
        for(int i = 1; i < A.length + 1; i++) {
            for(int j = 1; j < B.length + 1; j++) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result;
    }


    /*
       a b c d e
     a 1 1 1 1 1
     c 1 1 2 1 1
     e 1 1 2 2 3
     */

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     *  
     *
     * 示例 1:
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;

        /*
        子序列不用连续，所以不相同时，当前的值要继承左边或上边更大的一个
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1; i < text1.length() + 1; i++) {
            for(int j = 1; j < text2.length() + 1; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                //当当前两个值不相等时，继承左边或者上边
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


}

