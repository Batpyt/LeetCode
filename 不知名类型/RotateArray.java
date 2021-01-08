package 不知名类型;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
		for(int i : nums) {
			System.out.print(i+" ");
		}
	}

	//要求空间复杂度为O(1)
	public static void rotate(int[] nums, int k) {
		for(int i = 0; i < k; i++) {
			rightrotate(nums);
		}
	}

	public static void rightrotate(int[] nums) {
		int right = nums[nums.length - 1];
		for(int i = nums.length - 1; i >= 1; i--) {
			nums[i] = nums[i - 1];
		}
		nums[0] = right;
	}
}
