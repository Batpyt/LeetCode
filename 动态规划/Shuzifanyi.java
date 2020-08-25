package 动态规划;
/*
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

 */

/*
动态规划法，将到该位为止能翻译的结果储存。
公式为：dp[i] = dp[i-1]+dp[i-2]  if 10<=temp<=25
       dp[i] = dp[i-1]          if temp<=10 temp>=25
 */

public class Shuzifanyi {
    public static void main(String[] args) {
        int num = 506;

        System.out.println(translateNum(num));
    }

    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];  //多存一位，因为dp[1]对应str[0]
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            //System.out.println(temp);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                dp[i] = dp[i - 1] + dp[i - 2];
                System.out.println(dp[i] + " "+ temp);
            }
            else{
                dp[i] = dp[i - 1];
                System.out.println(dp[i]);
            }
        }
        return dp[str.length()];
    }


}


