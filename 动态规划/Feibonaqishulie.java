package 动态规划;

import java.util.Scanner;

public class Feibonaqishulie {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(fib(n));
		}
	}
	public static int fib(int n) {
		int sum = 0;
		int a = 0;
		int b = 1;
		
		for(int i = 0; i < n; i++) {
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		
		
		return a;
        

    }
	
	

}
