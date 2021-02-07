package 排序;

import java.util.*;

public class PrintOnettoN {
	public static void main(String[] args) {
		int[] res = printNumbers(2);
		for(int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] printNumbers(int n) {
		int size = (int)Math.pow(10, n) - 1;
		int[] res = new int[size];
		for(int i = 1; i <= size; i++) {
			res[i - 1] = i;
		}
		return res;
	}
}
