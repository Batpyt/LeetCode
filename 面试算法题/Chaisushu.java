package 面试算法题;
import java.io.*;

public class Chaisushu {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int size = Integer.parseInt(line);
			String[] s = bf.readLine().split(" ");
			int[] num = new int[size];
			
			int count = 0;
			for(int i = 0; i < s.length; i++) {
				num[i] = Integer.parseInt(s[i]);
				count = count + Su(num[i]);
				//System.out.println(num[i]);
			}
			
			System.out.println(count);
		}
	}
	
	public static int Su(int n) {
		if(n == 1) {
			return 0;
		}
		if(n == 3) {
			return 1;
		}
		if(n % 2 == 0) {
			return n / 2;
		}
		else {
			return  1 + ((n - 3) / 2);
		}
		
	}

}
