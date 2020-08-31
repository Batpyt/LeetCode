package 面试算法题;
/*
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Gupiao {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int[] sale = new int[prices.length];
		sale[prices.length - 1] = -1;
		
		for(int i = prices.length - 2; i >= 0; i--) {  //先找每个数右边的最大值
			sale[i] = Math.max(sale[i + 1], prices[i + 1]);
		}
		int res = 0;
		for(int i = 0; i < prices.length - 1; i++) {  //在用每个位置对应的右边最大值与该值相减，若大于0则取更大的值。
			int get = sale[i] - prices[i];
			if(get > 0) {
				res = Math.max(res, get);
			}
		}
		return res;
	}

}
