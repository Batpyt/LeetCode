package 排序;

import java.util.Arrays;

public class Yibanyishangdeshu {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		System.out.println(Yiban(num));
	}
	
	public static int Yiban(int[] num) {
		Arrays.sort(num);
		
		return num[num.length / 2];
	}
}
