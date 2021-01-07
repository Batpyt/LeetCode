package 二分法;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {6,7,8,1,2,3,4,5};
        System.out.println(findMin(nums));
    }

    //二分法
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
            System.out.println(left+" "+right);
        }
        return nums[left];
    }
}
