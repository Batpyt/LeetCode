package 面试算法题;
import java.io.*;
import java.util.Arrays;

public class Chuxianzuiduo {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int size = Integer.parseInt(line);
			String[] str = bf.readLine().split(" ");
			int[] num = new int[str.length];
			
			for(int i = 0; i < str.length; i++) {
				num[i] = Integer.parseInt(str[i]);
			}
			String[] res = Count(num).split(" ");
			System.out.println(res[0]);
			System.out.println(Integer.parseInt(res[1]) + 1);
		}
		
	}
	
	public static String Count(int[] num) {
		Arrays.sort(num);
		int max = 0;
		int count = 0;
		int j = 0;
		
		for(int i = 1; i < num.length; i++) {
			if(num[i] == num[i - 1]) {
				count++;
				if(count > max) {
					max = count;
					j = num[i];
				}
			}
			else {
				count = 0;
			}
			
			
			
			//System.out.println(num[i]);
		}
		String res = j + " " + max;
		return res;
	}

}
