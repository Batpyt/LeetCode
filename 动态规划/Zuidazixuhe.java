package 动态规划;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
/*

 */

public class Zuidazixuhe {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    /*
    动态规划法，
    若该位置的值加前一位置的值大于该位置的值，将该位置的值该为该位置+前一个位置。
    并与最大和值对比。
     */
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];  //初始最大和为第一个元素
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + nums[i] > nums[i]) nums[i] = nums[i - 1] + nums[i];
            if(nums[i] >= res) res = nums[i];
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(sum <= 0) {
                sum = nums[i];
            }
            else {
                sum = sum + nums[i];
            }

            if(sum >= max) max = sum;
        }

        return max;
    }


}
