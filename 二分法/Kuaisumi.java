package 二分法;
/*
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */

public class Kuaisumi {
	public static void main(String[] args) {
		int x = 2;
		int n = 4;
		System.out.print(myPow(x, n));
	}
	
	public static double myPow(double x, int n) {
		long N = n;
		return n >= 0 ? fastMul(x, N) : 1.0 / fastMul(x , -N);
		
	}
	
	public static double fastMul(double x, long n) {
		double res = 1.0;
		double tempx = x;
		while(n > 0) {
			if(n % 2 == 1) {
				res = res * tempx;
			}
			tempx = tempx * tempx;
			n = n / 2;
		}
		return res;
		
	}
}
