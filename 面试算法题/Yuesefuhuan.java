package 面试算法题;
/*
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
/*
 * 约瑟夫环问题，反推公式：
 * 最后剩的数下标为0，下表+补位的数量再和模上当前数组大小。
 */

public class Yuesefuhuan {
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		System.out.println(lastRemaining(n, m));
	}
	
	public static int lastRemaining(int n, int m) {
		int res = 0;  //最后一轮所剩数字的下标
		for(int i = 2; i <= n; i++) {
			res = (res + m) % i;  //加上跳过的数量再模当前数组大小
		}
		return res;
	}

}
