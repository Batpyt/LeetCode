package 排序;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Map;

public class SortByAbs {
    public static void main(String[] args) {
        int[] nums = {-4,-2,-1,0,1,4,5};
        int[] res = sortByAbs(nums);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] sortByAbs(int[] nums) {
        int mid = 0;
        for(int num : nums) {
            if(num >= 0) {
                break;
            }
            mid++;
        }
        if(mid >= nums.length) return nums;
        if(mid == 0) {
            int[] res = new int[nums.length];
            int index = 0;
            for(int i = nums.length - 1; i >= 0; i--) {
                res[index] = nums[i];
                index++;
            }
            return res;
        }

        int[] res = new int[nums.length];
        int index = 0, left = mid - 1, right = mid;
        //System.out.println(left + " " + right);
        while(index < nums.length) {
            //System.out.println(nums[left] +" "+ nums[right]);
            System.out.println(left +" "+ right);
            if(left < 0) {
                res[index] = nums[right];
                index++;
                right++;
                continue;
            }
            if(right >= nums.length) {
                res[index] = nums[left];
                index++;
                left--;
                continue;
            }
            if(Math.abs(nums[left]) < nums[right]) {
                res[index] = nums[left];
                left--;
            }
            else {
                res[index] = nums[right];
                right++;
            }
            System.out.println(res[index]);
            index++;
        }
        return res;
    }
}
