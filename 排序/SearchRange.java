package 排序;

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        for(int i : searchRange(nums, 7)) {
            System.out.println(i);
        }

    }


    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = 0;
        int j = nums.length - 1;

        while(nums[i] != target) {
            i++;
            if(i == nums.length) return new int[]{-1, -1};
        }

        while(nums[j] != target) {
            j--;
        }
        return new int[]{i,j};

    }
}
