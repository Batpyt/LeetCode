package 面试算法题;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Qichelirun {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int size = Integer.parseInt(line.split(" ")[0]);
			int a = Integer.parseInt(line.split(" ")[1]);
			int b = Integer.parseInt(line.split(" ")[2]);
			
			int i = 0;
			int[][] num = new int[size][2];
			while(i < size) {
				String[] temp = bf.readLine().split(" ");
				num[i][0] = Integer.parseInt(temp[0]);
				num[i][1] = Integer.parseInt(temp[1]);
				
				//System.out.println(num[i][0] + " "+num[i][1]);
				i++;
			}
			
			System.out.println(Max(num, a, b));
		}
		
	}
	
	public static int Max(int[][] num, int a, int b) {
		int res = 0;
		int max0 = 0;
		int da = 0;
		int db = 0;
		int max1 = 1;
		int counta = 0;
		int countb = 0;
		
		while(true) {
			if(counta < a || countb < b) {
				if(counta < a) {
					for(int i = 0; i < num.length; i++) {
						if(num[i][0] >= max0) {
							max0 = num[i][0];
							da = i;
						}
					}
//					num[da][0] = -1;
//					res = res + max0;
//					counta++;
				}
				
				if(countb < b) {
					for(int i = 0; i < num.length; i++) {
						if(num[i][1] >= max1) {
							max1 = num[i][1];
							db = i;
						}
					}
//					num[da][0] = -1;
//					res = res + max0;
//					counta++;
				}
				
				if(da != db) {
					num[da][0] = -1;
					num[da][1] = -1;
					num[db][1] = -1;
					num[db][0] = -1;
					res = res + max0 + max1;
					counta++;
					countb++;
					max0 = 0;
					max1 = 0;
				}
				if(da == db) {
					if(max0 > max1) {
						num[da][0] = -1;
						num[da][1] = -1;
						res = res + max0;
						counta++;
						//max0 = 0;
						//System.out.println(da+" "+num[da][0]+num[da][1]);
					}
					else {
						num[db][1] = -1;
						num[db][0] = -1;
						res = res + max1;
						countb++;
						//max1 = 0;
						//System.out.println(db);
					}
					max0 = 0;
					max1 = 0;
				}
			}
			
			if(counta >= a && countb >= b) {
				break;
			}
			
		}
		
		
		return res;
	}
	
}
