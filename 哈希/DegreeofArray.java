package 哈希;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DegreeofArray {
	public static void main(String[] args) {
		int nums[] = {1, 2, 2, 3, 1};
		System.out.println(findShortestSubArray(nums));
	}

	/*
	找到出现次数最多且首位间距最短的元素
	 */
	public static int findShortestSubArray(int[] nums) {
		/*
		用hashmap来记录，key为元素值，value为数组，arr[0]代表出现次数
		arr[1]代表该元素第一次出现的位置，arr[2]代表最后一次出现的位置
		 */
		Map<Integer, int[]> map = new HashMap<>();
		//记录每个元素信息
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.get(nums[i]) [0]++;
				map.get(nums[i]) [2] = i;
			}
			else {
				map.put(nums[i], new int[]{1, i, i});
			}
		}

		int maxcount = 0, minlen = 0;
		for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
			int arr[] = entry.getValue();
			//寻找出现次数最多的元素
			if(arr[0] > maxcount) {
				maxcount = arr[0];
				minlen = arr[2] - arr[1] + 1;
			}
			//若出现次数一样，取间隔最小的
			else if(arr[0] == maxcount) {
				minlen = Math.min(minlen, arr[2] - arr[1] + 1);
			}
		}
		return minlen;
	}
}

