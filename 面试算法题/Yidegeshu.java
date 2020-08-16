package 面试算法题;
import java.util.*;
/*
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。


 */

public class Yidegeshu {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			System.out.println(hammingWeight(num));
		}
		
	}
	
	public static int hammingWeight(int n) {
		int res = 0;
		String str = Integer.toBinaryString(n);
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				res++;
			}
		}
		
		
		
		return res;
	}
		
	

}
