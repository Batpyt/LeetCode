package 面试算法题;
/*
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

 */
public class SmallerthanCurrent {
    public static void main(String[] args) {
        int [] nums = {8,1,2,2,3};
        int[] res = smallerNumbersThanCurrent(nums);
        for(int i : res) {
            System.out.println(i);
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int [] count = new int[nums.length];
         for(int i = 0; i < nums.length; i++) {
             for(int j = 0; j < nums.length; j++) {
                 if(nums[j] < nums[i]) count[i]++;
             }
         }
         return count;
    }

}
