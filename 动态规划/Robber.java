package 动态规划;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Robber {
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
		int[] n = {1,2,3,1};
		System.out.println(robRing(n));
	}

	public static int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		//dp数组，记录到当前位置的最佳结果
		int[] dp = new int[nums.length];
		//第一家一定抢
		dp[0] = nums[0];
		//第二家的最佳结果取决于前两家哪个更多
		dp[1] = Math.max(dp[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			//最佳结果为前两家和当前的和和前一家哪个多
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	/**
	 *
	 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

	 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



	 示例 1：

	 输入：nums = [2,3,2]
	 输出：3
	 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
	 示例 2：

	 输入：nums = [1,2,3,1]
	 输出：4
	 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	 偷窃到的最高金额 = 1 + 3 = 4 。
	 * @param nums
	 * @return
	 */

	public static int robRing(int[] nums) {
		int[] n = new int[nums.length - 1];
		//分别获取不包括第一个和最后一个的
		for(int i = 0; i < nums.length - 1; i++) {
			n[i] = nums[i];
		}
		int r1 = NoFisrtLast(n);

		for(int i = 1; i < nums.length; i++) {
			n[i-1] = nums[i];
		}
		int r2 = NoFisrtLast(n);

		//返回更多的
		return Math.max(r1, r2);
	}


	public static int NoFisrtLast(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int[] dp = new int[nums.length];
		//第一家一定抢
		dp[0] = nums[0];
		//第二家的最佳结果取决于前两家哪个更多
		dp[1] = Math.max(dp[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			//最佳结果为前两家和当前的和和前一家哪个多
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
}
