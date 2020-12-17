package Greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Stock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int[] p = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(p, 2));
    }

    /*
    动态规划，维护dp[n][2]数组，代表了第n天持有或不持有股票的情况
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;

        //1代表买入，利润为减去当天股票价格
        dp[0][1] = -prices[0];

        //也就是0代表持有现金，1代表持有邮票，最终要看持有现金
        for(int i = 1; i < prices.length; i++) {
            //第i天不持有股票的情况：前一天就没持有 / 前一天持有，以第i天股价卖掉股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            //第i天持有股票的情况：前一天就持有 / 前一天没持有，买入今天的股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;

        //1代表买入，利润为减去当天股票价格
        dp[0][1] = -prices[0] - fee;

        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}
