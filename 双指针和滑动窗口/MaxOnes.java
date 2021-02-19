package 双指针和滑动窗口;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxOnes {
	public static void main(String[] args) {
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.println(longestOnes(A, 3));
	}

	/*
	滑动窗口，窗口内的0不大于K，
	 */
	public static int longestOnes(int[] A, int K) {
		int count0 = 0, count = 0, left = 0, right = 0;
		int res = 0;
		for(right = 0; right < A.length;) {
			//右边进来1的情况
			if(A[right] == 1) {
				count++;
				right++;
				res = Math.max(count, res);
				continue;
			}
			//进来0但是没到K个
			if(A[right] == 0 && count0 < K) {
				count0++;
				count++;
				right++;
				res = Math.max(count, res);
				continue;
			}
			//进来0且达到K个
			if(A[right] == 0 && count0 >= K) {
				//左边界右移
				if(A[left] == 0) {
					count0--;
				}
				left++;
				count--;
				res = Math.max(count, res);
				continue;
			}
		}
		return res;
	}
}
