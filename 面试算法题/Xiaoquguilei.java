package 面试算法题;

import java.io.*;

public class Xiaoquguilei {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int size = Integer.parseInt(line.split(" ")[0]);
			int m = Integer.parseInt(line.split(" ")[1]);
			int i = 0;
			int[][] rela = new int[m][2];
			while(i < m) {
				String temp = bf.readLine();
				rela[i][0] = Integer.parseInt(temp.split(" ")[0]);
				rela[i][1] = Integer.parseInt(temp.split(" ")[1]);
				//System.out.println(rela[i][0] + " "+rela[i][1] + " "+i);
				i++;
			}
			
			
			
		}
	}
	
	public static String[] Xiaoqu(int[][] rela, int m, int size) {
		String[] res = new String[size];
		
		
		
		return res;
	}

}
