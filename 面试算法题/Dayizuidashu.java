package 面试算法题;

import java.util.*;

public class Dayizuidashu {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			
			int[] res = printNumbers(n);
			for(int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
			}
		}
	}
	
	public static int[] printNumbers(int n) {
		int num = 0;
		for(int i = 0; i < n; i++) {
			num = (int) (num + 9 * Math.pow(10, i));
		}
		
		int[] res = new int[num];
		for(int j = 0; j < res.length; j++) {
			res[j] = 1 + j;
		}
		
		return res;
	}

}
