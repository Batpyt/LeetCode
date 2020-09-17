package 排序;

public class qSort {
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,5,2};
        QuickSort(nums, 0, nums.length - 1);
        for(int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void QuickSort(int[] nums, int low, int high) {
        if(low < high) {
            int index = partition(nums, low, high);
            QuickSort(nums, low, index - 1);
            QuickSort(nums, index + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int key = nums[low];

        while(low < high) {
            while(low < high && nums[high] >= key) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= key) low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        return low;
    }
}
