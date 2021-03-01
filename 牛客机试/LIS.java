package 牛客机试;

import java.util.Scanner;

public class LIS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int size = Integer.parseInt(sc.nextLine());
			String[] s = sc.nextLine().split(" ");
			int[] nums = new int[size];
			for(int i = 0; i < size; i++) {
				nums[i] = Integer.parseInt(s[i]);
			}
			System.out.println(LIS(nums));
		}
	}

	public static int LIS(int[] nums) {
		int[] dp = new int[nums.length];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
