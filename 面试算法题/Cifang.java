package 面试算法题;
/*
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

输入: 2.00000, 10
输出: 1024.00000
 */

public class Cifang {
	public static void main(String args[]) {
		double x = 2;
		int n = 6;
		
		System.out.println(myPow(x, n));
		
	}
	
	
	public static double myPow(double x, int n) {
		long m = n;
		if(m < 0) {
			m = -m;
			return 1 / Pow(x, m);
		}
		else {
			return Pow(x, m);
		}
		
    }
	public static double Pow(double x, long n) {
		double res = 1;
		if(n == 0) {
			return 1;
		}
		
		if(x == 1) {
			return 1;
		}
		
		if(n % 2 == 0) {
			res = Pow(x, n / 2);
			return res * res;
		}
		else {
			res = Pow(x, (n - 1) / 2);
			return res * res * x;
		}
		
	}

}
