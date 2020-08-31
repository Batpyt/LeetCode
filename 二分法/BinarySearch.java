package 二分法;

public class BinarySearch {

	
	public static int binarySearch(int[] nums, int target) {
	    int left = 0; 
	    int right = nums.length - 1; // 注意

	    while(left <= right) {
	        int mid = left + (right - left) / 2;
	        if(nums[mid] == target)
	            return mid; 
	        else if (nums[mid] < target)
	            left = mid + 1; // 注意
	        else if (nums[mid] > target)
	            right = mid - 1; // 注意
	    }
	    return -1;
	}

}
