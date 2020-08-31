package 二分法;
/*
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

 */
/*
 * 二分法，一分为二后先判断mid是在前半段还是后半段。
 * 然后再判断target的位置，调整前后边界。
 */

public class Paixuxuanzhuanshuzu {
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums,int target) {
		if(nums.length == 0) return -1;
		if(nums.length == 1) return nums[0] == target ? 0 : -1;
		int l = 0;
		int r = nums.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(nums[mid] == target) return mid;
			if(nums[0] <= nums[mid]) {  //当mid在前半段（4，5，6，7）
				if(nums[0] <= target && target <= nums[mid]) {  //若target在0-mid范围内，右边界为mid-1
					r = mid - 1;
				}
				else {  //在0-mid外，左边届为mid+1
					l = mid + 1;
				}
			}
			else {  //当mid在后半段
				if(nums[mid] < target && target <= nums[nums.length - 1]) {  //若target在mid-nums.length，左边届为mid+1
					l = mid + 1;
				}
				else {  //不在该范围内，右边界为mid-1。
					r = mid - 1;
				}
			}
		}
		return -1;
		
	}

}
