package 双指针和滑动窗口;

/**
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 *
 * 一个子数组指的是原数组中连续的一个子序列。
 *
 * 请你返回满足题目要求的最短子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 *
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 *
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DeleteMinArray {
    public static void main(String[] args) {
        int[] n = {5,4,3,7,8,2,1};
        int[] n2 = {3,2,1,1};
        System.out.println(findLengthOfShortestSubarray(n2));
    }

    public static int findLengthOfShortestSubarray (int[] array) {
        if(array.length <= 1) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        while(left + 1 < array.length && array[left] >= array[left + 1]) {
            left++;
        }

        while(right - 1 >= 0 && array[right - 1] >= array[right]) {
            right--;
        }

        int res = Math.min(right, array.length - 1 - left);
        if(res == 0) {
            return 0;
        }

        //[0, left] [..., ...] [right, length]
        //0 - left, right - length 是非递增区间, try to 合并，中间的即为需要删除的
        //最终目标：
        //[0, leftindex][rightinex, length]，中间删除
        int leftindex = 0, rightindex = right;
        while(leftindex <= left && rightindex < array.length) {
            if(array[leftindex] >= array[rightindex]) {
                res = Math.min(res, rightindex - leftindex - 1);
                leftindex++;
            } else {
                rightindex++;
            }
        }
        return res;
    }
}
