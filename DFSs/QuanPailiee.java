package DFSs;

import java.util.*;

public class QuanPailiee {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, nums, 0);
		return res;
	}

	public static void dfs(List<List<Integer>> res, int[] nums, int cur) {
		if(cur == nums.length) {
			List<Integer> list = new ArrayList<>();
			for(int i : nums) {
				list.add(i);
			}
			res.add(list);
			return;
		}
		else {
			for(int i = cur; i < nums.length; i++) {
				swap(nums, cur, i);
				dfs(res, nums, cur+1);
				swap(nums, cur, i);
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
