package 双指针和滑动窗口;
/**
 * 寻找和为k的整数倍的，长度最小的子数组
 */

import java.util.*;
public class findArrays {
    public static void main(String[] args) {

    }

    public static List<int[]> findArray(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        int left = 0, right = 1;
        int sum = nums[left];
        for(right = 1; right < nums.length; right++) {
            sum += nums[right];
            if(sum == k && right - left + 1 > 1) {
                int[] temp = new int[right - left + 1];
                int lefttemp = left;
                for(int index = 0; index < temp.length; index++) {
                    temp[index] = nums[lefttemp];
                    lefttemp++;
                }
                map.put(temp, temp.length);
            }
            else if(sum < k) {
                continue;
            }
            else if(sum > k) {
                sum -= nums[left];
                left++;
            }
            else {
                continue;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int value : map.values()) {
            min = Math.min(min, value);
        }
        for(int[] n : map.keySet()) {
            if(map.get(n) == min) {
                list.add(n);
            }
        }
        return list;
    }
}