package 面试算法题;
import java.io.*;

public class Maidongxi {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		 while((line = bf.readLine()) != null) {
			 int yusuan = Integer.parseInt(line);
			 int size = Integer.parseInt(bf.readLine());
			 int[] p = new int[size];
			 int[] v = new int[size];
			 String[] s = new String[2];
			 
			 for(int i = 0; i< size; i++) {
				 s = bf.readLine().split(" ");
				 p[i] = Integer.parseInt(s[0]);
				 v[i] = Integer.parseInt(s[1]);
			 }
			 
			 
			 
			 
		 }
		
		
	}

}
