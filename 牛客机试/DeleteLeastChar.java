package 牛客机试;

import java.util.*;

public class DeleteLeastChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String str = scan.nextLine().toLowerCase();
			Map<Character, Integer> map = new HashMap<>();
			for(char c : str.toCharArray()) {
				if(!map.containsKey(c)) {
					map.put(c, 1);
				}
				else {
					map.put(c, map.get(c) + 1);
				}
			}
			//System.out.println(map);

			int min = Integer.MAX_VALUE;
			for(int i : map.values()) {
				min = Math.min(min, i);
				//System.out.println(min);
			}

			StringBuilder sb = new StringBuilder();
			for(char c : str.toCharArray()) {
				if(map.get(c) == min) continue;
				else {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
