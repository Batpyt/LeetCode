package 双指针和滑动窗口;

public class WiggleSubsequence {
	public static void main(String[] args) {
		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(wiggleMaxLength(nums));
	}

	/*
	直接计算波峰波谷的个数
	 */
	public static int wiggleMaxLength(int[] nums) {
		if(nums.length < 2) {
			return nums.length;
		}
		int up = 1, down = 1;
		for(int i = 1; i < nums.length; i++) {
			//这种写法，当有连续两个上升趋势时，up不会更新，因为down没有更新，
			//连续两个下降趋势同理
			//所以只有当上升下降交替出现时，up，down才会增加
			if(nums[i] > nums[i - 1]) up = down + 1;
			if(nums[i] < nums[i - 1]) down = up + 1;
			System.out.println(nums[i-1] +" "+ nums[i] +" " +up+" "+down);
		}
		return Math.max(up, down);
	}
}

