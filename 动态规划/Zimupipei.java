package 动态规划;
/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
 */
/*
动态规划，dp[i],计算到i的位置为止，前面的能匹配的可能性。
第一个字符若不是0则dp[0] = 1。
之后的字符每一次都判断是不是0，不是，则+dp[i-1]，然后判断能否与前面的字符组成10-26。若能，则+dp[i-1]+dp[i-2]

 */

public class Zimupipei {
    public static void main(String[] args) {
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != '0') dp[i] = dp[i - 1];  //若当前位置不是0，则可以编译为一种。

            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');  //若和前一个可以组合成10-26，则可以再编译为一种
            if(10 <= num && num <= 26) {
                if(i == 1) dp[i]++;  //特殊值，第二个字符。
                else dp[i] = dp[i] + dp[i - 2];  //由于dp已经赋值完，要么是0要么是dp[i-1]，可以拿来用
            }
        }

        return dp[s.length() - 1];
    }
}
