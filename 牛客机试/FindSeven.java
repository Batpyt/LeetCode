package 牛客机试;

import java.util.*;

public class FindSeven {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = Integer.parseInt(scanner.nextLine());
			int count = 0;
			for(int i = 1; i <= n; i++) {
				if(i % 7 == 0) {
					count++;
					//System.out.println(i);
					continue;
				}
				if(String.valueOf(i).contains("7")) {
					//System.out.println(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
