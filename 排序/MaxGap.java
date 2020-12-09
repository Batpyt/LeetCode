package 排序;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxGap {
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
