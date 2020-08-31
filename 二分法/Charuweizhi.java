package 二分法;

/*
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
/*
 * 二分法。
 */
public class Charuweizhi {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums, 3));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 4));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		int mid = 0;
		while(l <= r) {
			mid = l + (r - l) / 2;  //不用（l+r)/2是因为这样可能会溢出
			if(nums[mid] == target) return mid;
			if(nums[mid] < target) l = mid + 1;
			if(nums[mid] > target) r = mid - 1;
		}
		return l;
	}

}
