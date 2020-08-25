package 面试算法题;
/*
 * abc
 * abcd
 * 1 1 2 3 5 8 13
 * f(n) = f(n - 1) + f( n -2)
 */
public class Shence {
	public static void main(String[] args) {
		System.out.println(f(5));
	}
	
	public static int f(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}

}
