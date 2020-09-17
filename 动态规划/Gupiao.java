package 动态规划;
/*
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
/*
 * 动态规划，每次都取最小的买入值，保存最大的卖出-买入。
 */
public class Gupiao {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int cost = Integer.MAX_VALUE;
		int sale = 0;
		for(int num : prices) {
			cost = Math.min(cost, num);
			sale = Math.max(sale, num - cost);
		}
		return sale;
	}
}
