package 面试算法题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 两个数之间的数，去掉某一位，既是回文又是素数的数量。
 */

public class Huiwensushu {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			String[] s = line.split(" ");
			int num1 = Integer.parseInt(s[0]);
			int num2 = Integer.parseInt(s[1]);
			
			int count = 0;
			int[] num= new int[num2 - num1 + 1];
			for(int i = num1; i < num2 + 1; i++) {
				//System.out.println(i);
				if(Hui(i)) {
					count++;
				}
			}
			System.out.println(count);
			
			
		}
	}
	
	public static boolean Hui(int num) {
		Integer n = num;
		//System.out.println(n);
		String s = n.toString();
		boolean res = false;
		int[] arr = new int[s.length()];
//		for(int i = 0; i < arr.length; i++) {
//			Character c = s.charAt(i);
//			arr[i] = Integer.parseInt(c.toString());
//			//System.out.println(arr[i]);
//		}
		for(int i = 0; i < arr.length; i++) {
			if(res) {
				break;
			}
			String str = "";
			int j = 0;
			while(j < arr.length) {
				if(j != i) {
					str = str + s.charAt(j);
					j++;
				}
				else {
					j++;
				}
			}
			boolean huiwen = new StringBuilder(str).reverse().toString().equals(str);
			
			if(huiwen) {
				//System.out.println(str);
				boolean sushu = true;
				if(Integer.parseInt(str) == 1) {
					sushu = false;
				}
				else if(Integer.parseInt(str) > 2) {
					for(int k = 2; k < Integer.parseInt(str); k++) {
						if( Integer.parseInt(str) % k == 0) {
							sushu = false;
							break;
						}
					}
				}
				
				if(sushu) {
					res = true;
					//System.out.println(num);
				}
			}
			else {
				
			}
		}
		
		
		return res;
	}

}
