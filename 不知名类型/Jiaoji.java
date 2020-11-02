package 不知名类型;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
给定两个数组，编写一个函数来计算它们的交集。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
 */

public class Jiaoji {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] res = intersection(nums1, nums2);
        for(int i : res) {
            System.out.println(i);
        }
    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i : nums1) {
            s1.add(i);
        }
        for(int i : nums2) {
            if(s1.contains(i)) s2.add(i);
        }
        int[] res = new int[s2.size()];
        int index = 0;
        for(int i : s2) {
            res[index] = i;
            index++;
        }
        return res;
    }
}
