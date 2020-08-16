package 面试算法题;

import java.util.*;

public class Juzhenxuanzhuan {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[][] m = new int[n][n];
			int[][] mm = new int[n][n];
			int k = n - 1;
			
			for(int i = 0; i < n; i++,k--) {
				for(int j = 0; j < n; j++) {
					m[i][j] = sc.nextInt();
					mm[j][k] = m[i][j];
					//System.out.println(m[i][j]);
				}
			}
			
			//int[][] mm = new int[n][n];
			//int k = n - 1;
//			for(int i = 0; i < n; i++, k--) {
//				for(int j = 0; j < n; j++) {
//					mm[j][k] = m[i][j];
//					//System.out.println(mm[i][j]);
//				}
//			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.println(mm[i][j]);
				}
			}
			
			
		}
	}

}
