package 二分法;
/*
 * 统计一个数字在排序数组中出现的次数。
 */

public class Chuxiancishu {
	public static void main(String[] args) {
		int[] num = {5,7,7,8,8,10};
		int[] num2 = {0,2,3,4,5,6,7,8,9};
		
		System.out.println(search(num, 8));
	}
	
	/*
	 * 二分法，得出要统计的数的前后的位置索引再相减。
	 */
	public static int search(int[] nums, int target) {
		return Find(nums, target) - Find(nums, target - 1);
	}
	
	public static int Find(int[] nums, int target) {
		//int res = 0;
		int i = 0;
		int j = nums.length - 1;
		
		while(i <= j) {
			int m = (i + j) / 2;
			if(nums[m] <= target) {
				i = m + 1;
			}
			else {
				j = m - 1;
			}
		}
		
		return i;
	}
}
