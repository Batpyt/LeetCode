package 动态规划;

import java.util.Scanner;

public class Qingwatiaotaijie {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(numWays(n));
		}
	}
	
    public static int numWays(int n) {
    	int a = 1;
    	int b = 1;
    	int sum = 0;
    	for(int i = 0; i < n; i++) {
    		sum = (a + b) % 1000000007;
    		a = b;
    		b = sum;
    	}
    	
    	return a;
    }

}
