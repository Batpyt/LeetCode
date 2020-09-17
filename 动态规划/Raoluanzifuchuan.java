package 动态规划;
/*
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
示例 1：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true

示例2：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false
 */
/*
动态规划。新建dp[i][j]。
判断s1的第i-1和s2的第j能否组成s3的i+j-1。
  0 d b b c a
0 T F F F F F
a T F F F F F
a T T ...
d ...
b
b

 */
public class Raoluanzifuchuan {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";

        System.out.println(isInterleave(s1,s2,s3));
        System.out.println(isInterleave(s1,s2,s4));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;  //边界条件，0，0和0

        for(int i = 0; i <= s1.length(); ++i) {
            for(int j = 0; j <= s2.length(); ++j) {
                int p = i + j - 1;
                if(i > 0) {  //判断>0，因为有第0列和第0行没有值。
                    dp[i][j] = dp[i][j] || dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(p));
                }
                if(j > 0) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
