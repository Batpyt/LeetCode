package 面试算法题;

import java.io.*;

public class Pailie {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int n = Integer.parseInt(line.split(" ")[0]);
			int m = Integer.parseInt(line.split(" ")[1]);
			//System.out.println(n + " "+m);
			
			String[] s = bf.readLine().split(" ");
			int[] num = new int[m];
			for(int i = 0; i < m; i++) {
				num[i] = Integer.parseInt(s[i]);
				//System.out.println(num[i]);
			}
			//System.out.println(Integer.parseInt(s , 0));
			
		}
		
		
	}
	
	public static boolean Zidian(int n, int m) {
		String sn = Integer.toString(n);
		String sm = Integer.toString(m);
		//boolean res = true;
		
		if(sn.length() > sm.length()) {
			return true;
		}
		else if(sn.length() < sm.length()) {
			return false;
		}
		else {
			for(int i = 0; i < sn.length(); i++) {
				if(sn.charAt(i) < sm.charAt(i)) {
					return false;
				}
			}
		}
		return true;
		
		
	}

}
