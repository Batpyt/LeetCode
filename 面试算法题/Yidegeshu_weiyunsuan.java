package 面试算法题;

import java.util.Scanner;
/*
 * 
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

 */

public class Yidegeshu_weiyunsuan {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			System.out.println(hammingWeight(num));
		}
	}
	
	/*
	 * 位运算法。二进制性质：二进制的数与1做与运算，若最右位为1，结果为1，若最右为0，结果为0.
	 * >>> 无符号位运算，将整数变为二进制之后向右移一位，运算结果为 
	 */
	public  static int hammingWeight(int n) {
        int res = 0;
		
        while(n != 0) {
        	res = res + (n & 1);
        	n = n >>> 1;
        	//System.out.println(res);
        }
		
		
		
		
		
		return res;
    }

}
