package 面试算法题;
/*
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
 */
/*
对撞指针，一个指头一个指尾。
若相加大于目标，尾指针往前，
若相加小于目标，头指针向后。
若相等则返回，若指针相遇也没有相等的一对的话返回0。
 */

public class Heweis {
    public static void main(String[] args) {
        int[] nums = {14,15,16,22,53,60};
        int target = 76;
        for(int num : twoSum(nums, target)){
            System.out.println(num);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            if(nums[j] + nums[i] > target) {
                j--;
            }
            if(nums[i] + nums[j] < target) {
                i++;
            }
            if(nums[i] + nums[j] == target) {
                return new int[] {nums[i], nums[j]};
            }
        }
        return new int[] {0};
    }
}
