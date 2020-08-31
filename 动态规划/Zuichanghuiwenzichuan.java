package 动态规划;
/*
给定一个字符串 s，找到 s 中最长的回文子串
 */
/*
动态规划，新建二维数组来记录范围为i-j的子串是不是回文。
 */

public class Zuichanghuiwenzichuan {
    public static void main(String[] args) {
        String s = "bababdd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {  //对角线的均为true
            dp[i][i] = true;
        }

        char[] arr = s.toCharArray();
        for(int j = 1; j < s.length(); j++) {  //按列往后判断
            for(int i = 0; i < j; i++) {
                if(arr[i] != arr[j]) dp[i][j] = false;  //若首尾不相同，不是回文
                else {
                    if(j - i < 3) dp[i][j] = true;  //若首尾相同且长度为1或2，为回文
                    else dp[i][j] = dp[i + 1][j - 1];  //其他情况参照i+1，j-1的矩阵值。
                }
            }
        }

        int l = 0;
        int r = 0;
        int max = 0;
        for(int j = s.length() - 1; j > 0; j--) {  //找到最长的子串
            for(int i = 0; i < j; i++) {
                if(dp[i][j]) {
                    if(j - i > max) {
                        max = j - i;
                        l = i;
                        r = j;
                    }
                }
            }
        }

        return s.substring(l, r + 1);
    }
}
