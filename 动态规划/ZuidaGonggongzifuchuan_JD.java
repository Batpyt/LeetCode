package 动态规划;

import java.io.*;

public class ZuidaGonggongzifuchuan_JD {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			double size = Integer.parseInt(line);
			String ss1 = bf.readLine();
			String ss2 = bf.readLine();
			
			String[] s1 = ss1.split(" ");
			String[] s2 = ss2.split(" ");
			
			double res = Count(s1, s2)/size;
			//double t = 2.0/3.0;
			//System.out.println(String.format("%.2f", t)+" "+t);
			if(res > 0.5) {
				System.out.println(String.format("%.2f", res) + " No");
			}
			else {
				System.out.println(String.format("%.2f", res) + " Yes");
			}
			
			
		}
	}
	
	public static double Count(String[] s1, String[] s2) {
		int[][] res = new int[s1.length ][s2.length];
		int max = 0;
		for(int i = 1; i < s1.length; i++) {
			for(int j = 1; j < s2.length; j++) {
				if(s1[i - 1].equals(s2[j - 1])) {
					res[i][j] = res[i - 1][j - 1] + 1;
				}
				else {
					//res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
					if(res[i - 1][j] > res[i][j - 1]) {
						res[i][j] = res[i - 1][j];
					}
					else {
						res[i][j] = res[i][j - 1];
					}
				}
				//max = Math.max(max, res[i][j]);
				if(max < res[i][j]) {
					max = res[i][j];
				}
			}
		}
		
		
		
		return max;
	}

}
