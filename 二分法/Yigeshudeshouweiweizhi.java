package 二分法;

public class Yigeshudeshouweiweizhi {
	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int target = 8;
		int target2 = 3;
		System.out.println(searchRange(nums, target)[0] +" "+ searchRange(nums, target)[1]);
		System.out.println(searchRange(nums, target2)[0] +" "+ searchRange(nums, target2)[1]);
		System.out.println(searchRange(nums, 5)[0] +" "+ searchRange(nums, 5)[1]);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) return new int[] {-1, -1};
		int i = 0;
		int j = nums.length - 1;
		boolean f1 = false;
		boolean f2 = false;
		while(i <= j) {
			if(nums[i] == target) f1 = true;
			if(nums[j] == target) f2 = true;
			if(f1 && f2) return new int[] {i, j};
			if(!f1) i++;
			if(!f2) j--;
		}
		if(!f1 && !f2) return new int[] {-1, -1};
		
		return new int[] {i,j};
	}
	

}
