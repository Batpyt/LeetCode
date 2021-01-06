package Greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Stock1 {
    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        System.out.println(maxProfit2(p));
        int[] p2 = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfitTwice(p2));
    }


    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        //今天之前的最小买入价格
        int min = prices[0];
        //今天卖出的最大收益
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            //记录每次卖出的最大收益
            max = Math.max(max, prices[i] - min);
            //记录每天的最小买入价格
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        //买了股票
        int buy = -prices[0];
        //卖了股票
        int sell = 0;
        for(int i = 1; i < prices.length; i++) {
            //由于是负数，最大的即为最便宜的买入价格
            buy = Math.max(buy, -prices[i]);
            //记录卖出后最大的收益
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /*
    与单次买卖解法相似
     */
    public static int maxProfitTwice(int[] prices) {
        if(prices.length < 2) return 0;
        int sell1 = 0, sell2 = 0;
        int buy1 = - prices[0], buy2 = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);

            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
