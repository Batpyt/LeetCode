package 面试算法题;
/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class Jioufenkai {
	public static void main(String args[]) {
		int[] num = {1, 2, 3, 4};
		
		int[] res = exchange(num);
		for(int i = 0; i < num.length; i++) {
			System.out.print(res[i]);
		}
	}
	
	public static int[] exchange(int[] nums) {
		int[] res = new int[nums.length];
		int j = 1; //右指针
		int k = 0; //左指针
		for(int i = 0; i < res.length; i++) {
			if(nums[i] % 2 != 0) {
				res[k] = nums[i];
				k++;
				//System.out.println(res[i]);
			}
			else {
				res[res.length - j] = nums[i];
				j++;
			}
		}
		
		
		return res;
    }

}
