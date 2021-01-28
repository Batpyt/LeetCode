package 不知名类型;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MidIndex {
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		int[] n = {-1,-1,-1,0,1,1};
		System.out.println(pivotIndex(n));
	}

	public static int pivotIndex(int[] nums) {
		int total = 0;
		for(int i : nums) {
			total = total + i;
		}

		int index = 0;
		int sum = 0;
		while(true) {
			if(index > 0) {
				sum = sum + nums[index - 1];
			}
			System.out.println(sum +", "+total);
			if(sum == total - sum - nums[index]) return index;
			index++;
			if(index >= nums.length) return -1;
		}
	}

	public static int pindex(int[] nums) {
		int total = 0;
		for(int i : nums) {
			total = total + i;
		}

		//i之前的和*2加上i处的值=总和即可
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(2 * sum + nums[i] == total) return i;
			sum = sum + nums[i];
		}
		return -1;
	}
}
