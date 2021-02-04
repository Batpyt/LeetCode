package 双指针和滑动窗口;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxAverageSubarray {
	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums, 4));
	}

	/*
	滑动窗口简单题，重拳出击
	 */
	public static double findMaxAverage(int[] nums, int k) {
		int left = 0, right = k - 1;
		int sum = 0;
		int max = 0;
		for(int i = left; i <= right; i++) {
			sum = sum + nums[i];
		}
		max = sum;
		System.out.println(sum);

		for(right = k; right < nums.length; right++) {
			sum = sum + nums[right] - nums[left];
			System.out.println(sum);
			max = Math.max(sum, max);
			left++;
		}
		return (double)max / k;
	}
}
