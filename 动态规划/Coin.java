package 动态规划;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Coin {
    public int change(int amount, int[] coins) {
        //dp数据记录硬币总数为当前索引位置的总金额有多少种组合
        int dp[] = new int[amount + 1];
        //当总金额为0时，只有一种组合，就是不取
        dp[0] = 1;
        //遍历硬币组合
        for(int coin : coins) {
            //i为dp数组索引
            for(int i = 1; i <= amount; i++) {
                //当总金额>=硬币时，将i-coin所有的组合数和i处的组合数相加
                if(i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
