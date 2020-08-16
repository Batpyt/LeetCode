package 面试算法题;
import java.io.*;

public class Bihuan {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bf.readLine()) != null) {
			int size = Integer.parseInt(line);
			String[][] s = new String[size][2];
			int i = 0;
			while(i < size) {
				s[i] = bf.readLine().split(" ");
				//System.out.println(s[i][0] + s[i][1]);
				i++;
			}
			
			System.out.println(Cycle(s, size));
		}
		
	}
	
	public static int Cycle(String[][] s, int size) {
		String s0 = s[0][0];
		int count = 0;
		
		for(int i = 0; i < size; i++) {
			if(s0.equals(s[i][1])) {
				count++;
				if(i == size - 1) {
					break;
				}
				s0 = s[i + 1][0];
			}
			
		}
		
		
		return count;
	}

}
