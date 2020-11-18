package 不知名类型;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AppearOnce2 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    //笨办法，每次比较三个连续的是否相等
    public static int singleNumber(int[] nums) {
        if(nums.length < 3) return nums[0];
        Arrays.sort(nums);
        //0 0 0 1 1 1 99
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                i = i + 3;
                System.out.println(i);
                if(i >=   nums.length - 1) return nums[nums.length - 1];
            }
            else return nums[i];
        }
        return 0;
    }
}
