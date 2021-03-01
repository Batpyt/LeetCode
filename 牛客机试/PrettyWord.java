package 牛客机试;

import java.util.*;

public class PrettyWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			String[] str = new String[n];
			for(int i = 0; i < n; i++) {
				str[i] = sc.next();
			}

			for(int i = 0; i < n; i++) {
				Map<Character, Integer> map = new HashMap<>();
				for(char c : str[i].toCharArray()) {
					if(map.containsKey(c)) {
						map.put(c, map.get(c) + 1);
					}
					else {
						map.put(c, 1);
					}
				}
				//System.out.println(map);
				int[] nums = new int[map.keySet().size()];
				int index = 0;
				for(int j : map.values()) {
					nums[index] = j;
					index++;
				}
				Arrays.sort(nums);
				int p = 26;
				int sum = 0;
				for(int j = nums.length - 1; j >=0; j--) {
					//System.out.println(j + " "+p);
					sum += nums[j] * p;
					p--;
				}
				System.out.println(sum);
			}

		}
	}
}
