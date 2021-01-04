package 排序;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};
        merge(n1,3,n2,3);
        for(int i : n1){
            System.out.print(i+" ");
        }

    }

    /*
    双指针
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //p1 p2代表两个需要排序的数组的索引
        int p1 = m - 1;
        int p2 = n - 1;
        //p代表要复制的nums1的位置
        int p = m + n - 1;
        while(p1 >=0 && p2 >= 0) {
            // 1 2 【5】 0 0 0
            // 1 2 【3】
            if(nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
            else {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
     }
}
