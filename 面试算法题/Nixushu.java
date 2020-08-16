package 面试算法题;
import java.util.*;

public class Nixushu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int size = sc.nextInt();
			
			int count = 0;
			for(int i = 1; i <= size; i++) {
				if(Nixu(i, size) != -1) {
					count++;
				}
			}
			System.out.println(count);
			for(int i = 1; i <= size; i++) {
				if(Nixu(i, size) != -1) {
					System.out.println(i + " " + Nixu(i, size));
				}
			}
		}
	}
	
	public static int Nixu(int num, int size) {
		StringBuilder sb = new StringBuilder();
		int res = Integer.parseInt(sb.append(num).reverse().toString());
		
		if(res > size || res != num * 4) {
			return -1;
		}
		else{
			return res;
		}
	}

}
