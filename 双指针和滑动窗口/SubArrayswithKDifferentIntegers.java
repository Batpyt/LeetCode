package 双指针和滑动窗口;
/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class SubArrayswithKDifferentIntegers {
	public static void main(String[] args) {
		int[] A = {1,2,1,3,4};
		//System.out.println(subarraysWithKDistinct(A, 2));
		System.out.println(subarrays(A, 3));
	}

	public static int subarrays(int[] A, int K) {
		int left = 0, right = 0;
		Set<Integer> set = new HashSet<>();
		int count = 0;
		int cc = 0;

		for(right = left; right < A.length; right++) {
			set.add(A[right]);
			if(set.size() == K) {
				cc++;
				System.out.println(set);
			}
			if(set.size() > K) {
				int len = right - 1 - left + 1;
				int sum = (len - 1 + 1) * (len - 1) / 2;
				count += sum;
				cc = 0;
				set.remove(A[left]);
				left++;
				right--;
			}
		}
		return count+cc;
	}

	/*
	1 2 3 4 5
	12
	23
	34
	45
	123
	234
	345
	1234
	2345
	12345

	4+3+2+1 = 10
	（4+1） * 4/2 = 10

	 */
	public static int subarraysWithKDistinct(int[] A, int K) {
		int left = 0, right = 0;
		Set<Integer> set = new HashSet<>();
		int count = 0;

		for(left = 0; left < A.length; left++) {
			for(right = left; right < A.length; right++) {
				set.add(A[right]);
				if(set.size() == K) {
					count++;
				}
				if(set.size() > K) {
					break;
				}
			}
			set.clear();
		}
		return count;
	}
}
