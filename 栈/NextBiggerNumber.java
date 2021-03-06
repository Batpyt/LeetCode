package 栈;

import java.util.*;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NextBiggerNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] res = nextGreaterElements(nums);
        for(int i : res) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        //依然用单调栈，栈中储存的是元素的索引，
        //由于是循数组，所以循环次数延长一倍
        for(int i = 0; i < 2 * nums.length; i++) {
            //当前元素，当前元素索引用取模求出
            int num = nums[i % nums.length];
            //当栈中不为空，且当前元素大于栈顶元素时，说明比栈顶对应的索引的元素的下一个更大元素为当前元素
            while(!stack.isEmpty() && num > nums[stack.peek()]) {
                //栈顶对应的索引的元素的下一个更大元素为当前元素，记录
                res[stack.pop()] = num;
            }
            //将索引入栈
            if(i < nums.length) {
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
     *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
     *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
