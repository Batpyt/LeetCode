package 面试算法题;
import java.io.*;

public class Qumo {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = bf.readLine()) != null) {
			int a = Integer.parseInt(line.split(" ")[0]);
			int b = Integer.parseInt(line.split(" ")[1]);
			
			int res = Qumo(a, b);
			if(res == -1) {
				System.out.println("inf");
			}
			else {
				System.out.println(res);
			}
			
		}
	}
	
	public static int Qumo(int a, int b) {
		int res = 0;
		if(a == b) {
			return -1;
		}
		
		for(int i = 1; i < a; i++) {
			if(a % i == b) {
				res++;
				System.out.println(i);
				
				if(i > 999999) {
					return -1;
				}
			}
		}
		
		return res;
	}

}
