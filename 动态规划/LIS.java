package 动态规划;
/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
动态规划，维护一个dp数组，里面存放的是子序列尾部元素的值，例如：dp[k]存放的是长度为 k+1长度子序列的尾部元素
最终这个dp数组的长度为最大子序列的长度。dp呈递增。
从头开始遍历，在dp中寻找当前元素的位置，若该元素大于dp最后一个值，dp[k+1] = 当前元素。
 */

public class LIS {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] n = {2,3,7,21};
        System.out.println(lengthOfLIS(nums));
        System.out.println(LLIISS(nums));

        int[] de = {6, 5, 4, 7, 5, 3, 2, 1};
        System.out.println(lengthofDecrease(de));
    }
    public static int lengthOfLIS(int[] nums) {
        //dp数组
        int[] dp = new int[nums.length];
        //一开始的长度为0
        int res = 0;
        for(int num : nums) {
            //用二分法查找元素应该所在的位置
            //i和j和m找的是在dp中num的位置
            int i = 0, j = res;
            while(i < j) {
                //2 3 7
                //5
                int m = (i + j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            System.out.println(i + " " + num);
            //将元素计入位置
            dp[i] = num;
            //当j==res时，说明当前元素加入到了k+1，长度也要+1
            if(res == j) res++;
        }
        return res;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0;
            int j = res;
            while(i < j) {
                int m = (i+j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    // 6 5 4 7 5 3 2 1
    public static int lengthofDecrease(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int left = 0, right = res;
            while(left < right) {
                //7 4 1
                //5
                int m = (left + right) / 2;
                if(dp[m] > num) left = m + 1;
                else right = m;
            }
            dp[left] = num;
            if(res == right) res++;
        }
        return res;
    }

    public static int LLIISS(int[] nums) {
        int dp[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}
