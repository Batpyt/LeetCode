package 双指针和滑动窗口;

import java.util.*;

/**
 *
 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。

 例如：

 [2,3,4]，中位数是 3
 [2,3]，中位数是 (2 + 3) / 2 = 2.5
 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

 示例：

 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

 窗口位置                      中位数
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 */

public class SlidingWindowMedian {
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		double[] res = medianSlidingWindow(nums, 3);
		for(double r : res) {
			System.out.print(r+" ");
		}
	}

	/*
	暴力法
	 */
	public static double[] medianSlidingWindow(int[] nums, int k) {
		List<Double> res = new ArrayList<>();
		int left = 0, right = k - 1;
		for(right = k - 1; right < nums.length; right++) {
			int index = left;
			int[] arr = new int[k];
			int i = 0;
			//记录窗口内的数组
			while(index <= right) {
				arr[i] = nums[index];
				index++;
				i++;
			}
			//排序
			Arrays.sort(arr);

			//区分奇偶数个找中位数
			if(k % 2 != 0) {
				res.add((double)arr[(k-1) / 2]);
			}
			else {
				//特殊用例
				long n1 = arr[k/2];
				long n2 = arr[(k/2) - 1];
				long j = n1 + n2;
				res.add((double)j / 2);
			}
			left++;
		}
		double[] r = new double[res.size()];
		for(int i  = 0; i < r.length; i++) {
			r[i] = res.get(i);
		}
		return r;
	}
}
