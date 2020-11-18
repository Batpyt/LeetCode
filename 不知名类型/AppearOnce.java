package 不知名类型;

import java.util.Arrays;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AppearOnce {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        if(nums.length < 2) return nums[0];
        Arrays.sort(nums);
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        }

        return 0;
    }

    /*
    异或方法
    相同数异或=0，任何数异或0=自己
     */
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result = result ^ i;
        }
        return result;
    }

}
