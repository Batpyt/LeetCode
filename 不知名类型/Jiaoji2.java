package 不知名类型;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*

给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]


说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
 */

/*
排序后双指针
 */

public class Jiaoji2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] n1 = {4,9,5}, n2 = {9,4,9,8,4};
        int[] q = {}, w = {};
        //int[] res = intersect(nums1, nums2);
        int[] res = intersect(q, w);
        for(int i : res) {
            System.out.println(i);
        }
    }

    //1 1 2 2
    //2 2

    //4 5 9
    //4 4 8 9 9
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] r = {};
        if(nums1.length == 0 || nums2.length == 0) return r;

        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //双指针
        int i = 0, j = 0;
        //用来储存交际元素的链表
        List<Integer> l = new LinkedList<>();

        //循环时每次指针后移都判断是否已经遍历完当前数组
        while(true) {
            //若第一个数组的元素小于第二个数组，第一个数组的指针向后移
            if(nums1[i] < nums2[j]) {
                i++;
                if(i == nums1.length) break;
            }
            //相反
            if(nums1[i] > nums2[j]) {
                j++;
                if(j == nums2.length) break;
            }
            //若元素相等，记录元素，两个指针同时后移
            if(nums1[i] == nums2[j]) {
                l.add(nums1[i]);
                //System.out.println(nums1[i] + "qwe");
                i++;
                j++;
                if(i == nums1.length) break;
                if(j == nums2.length) break;
            }
        }

        //结果转移到数组中
        int[] res = new int[l.size()];
        int index = 0;
        for(int num : l) {
            res[index] = num;
            index++;
        }
        return res;
    }
}
