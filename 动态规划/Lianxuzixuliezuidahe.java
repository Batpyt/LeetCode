package 动态规划;
/*
 *  输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
/*
动态规划，将每每一位往前加的最大和保存在新的数组中。
新数组储存原则：若上一个大于0，则存如上一个值+当前的值。若上一个小于等于0，当前值不变。
如果上一个数小于0，意味着原数组加到上个数的最大和小于0，则从当前的数重新开始计算和。

比如：原数组为：[-2, 1,-3, 4,-1, 2, 1,-5, 4]。
   新数组则为：[-2, 1,-2, 4, 3, 5, 6, 1, 5]。
 */
public class Lianxuzixuliezuidahe {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = nums;  //dp存的就是原数组子序列到当前位置的数能得到的最大的和

        for(int i = 1; i < nums.length; i++) {
            if(dp[i - 1] <= 0){
                dp[i] = dp[i];
            }
            if(dp[i - 1] > 0) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if(dp[i] >= res) {
                res = dp[i];
            }
        }
        return res;
    }
}
