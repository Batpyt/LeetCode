package DFSs;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SubList2 {
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}

	/*
	先对nums进行排序，再dfs
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(nums, 0, res, path);
		return res;
	}

	//dfs
	public static void dfs(int[] nums, int begin, List<List<Integer>> res, List<Integer> path) {
		//将结果加入返回
		res.add(new ArrayList<>(path));
		for(int i = begin; i < nums.length; i++) {
			//若与上一个元素相等，则跳过本次循环
			if(i > begin && nums[i] == nums[i-1]) {
				continue;
			}
			//记录本次的元素
			path.add(nums[i]);
			dfs(nums, i+1, res, path);
			//不记录本次的元素
			path.remove(path.size() - 1);
		}
	}
}
