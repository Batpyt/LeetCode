package 排序;

public class IncreasingArray {
    public static void main(String[] args) {
        int[] nums = {1,2,5,4,6};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1) return 0;
        int res = 0;
        int cur = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                cur++;
                res = Math.max(cur, res);
                System.out.println(cur+" "+res);
            }
            else {
                cur = 0;
            }
        }
        return res > 0 ? res+1 : 0;
    }
}
