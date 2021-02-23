package 双指针和滑动窗口;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AngryBookStore {
	public static void main(String[] args) {
		int[] cus = {1,0,1,2,1,1,7,5};
		int[] g = {0,1,0,1,0,1,0,1};
		System.out.println(maxSatisfied(cus, g, 3));
	}

	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int sum = 0;
		//先计算所有不生气时候的满意度，同时把计算过的变为0
		for(int i = 0; i < customers.length; i++) {
			if(grumpy[i] == 0) {
				sum += customers[i];
				customers[i] = 0;
			}
		}

		/*
		然后用滑动窗口计算X范围内的最大值
		即为X范围内保持冷静能得到的最大值
		 */
		int temp = 0;
		for(int i = 0; i < X; i++){
			temp += customers[i];
		}
		int max = temp;

		for(int i = X; i < customers.length; i++) {
			temp = temp + customers[i] - customers[i - X];
			max = Math.max(temp, max);
		}
		return max + sum;
	}
}
