package 不知名类型;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        SubarraySum s = new SubarraySum();
        System.out.println(s.subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum == k) res++;
            }
        }
        return res;
    }
}
