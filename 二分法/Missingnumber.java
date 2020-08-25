package 二分法;
/*
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */

public class Missingnumber {
	public static void main(String[] args) {
		int[] num = {0,1,2,3,4,5,6,7,9};
		int[] num2 = {0,2,3,4,5,6,7,8,9};
		
		System.out.println(Missing(num));
	}
	/*
	 * 二分法，分为左右两个数组。左边数组的最后一位	nums[m] == m，所以若满足这个条件，缺失值就在右边，将左边界设为m+1.
	 * 相反地，右边界设为m-1.
	 * 、当做右边界相遇时，便找到了缺失值的索引位置。
	 */
	public static int Missing(int[] nums) {
		int res = 0;
		int i = 0;
		int j = nums.length - 1;
		while(i <= j) {
			int m = (i + j) / 2;
			if(nums[m] == m) {
				i = m + 1;
			}
			else {
				j = m - 1;
			}
		}
		
		return i;
		
		
	}

}
