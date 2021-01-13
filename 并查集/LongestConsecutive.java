package 并查集;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
	}

	/*
	将数组存入set中，遍历
	当遍历到的数字没有比他小1的时，开始寻找比他大1的直到找不到
	 */
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			set.add(num);
		}

		int longest = 0;
		for(int num : set) {
			//若没有比当前的小1的数字
			if(!set.contains(num - 1)) {
				int currentlong = 1;
				int current = num;
				//开始寻找大1的
				while (set.contains(current + 1)) {
					currentlong++;
					current++;
				}
				longest = Math.max(longest, currentlong);
			}
		}
		return longest;
	}
}
