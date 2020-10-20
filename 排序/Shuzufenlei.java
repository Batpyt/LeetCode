package 排序;

import java.util.Arrays;

public class Shuzufenlei {
    public static void main(String[] args) {
        Shuzufenlei f = new Shuzufenlei();
        int[] nums = {2,0,2,1,1,0};
        f.sortColors(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;
        for(int num : nums) {
            if(num == 0) count0++;
            else if(num == 1) count1++;
        }
        System.out.println(count0 + " " + count1);
        for(int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for(int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for(int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }

    }
}
