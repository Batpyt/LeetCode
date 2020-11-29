package 不知名类型;
import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LargestTriangle {
    public static void main(String[] args) {
        int[] a = {3,2,3,4};
        System.out.println(largestPerimeter(a));
    }

    /*
    排序后倒叙找连续三个数达到两边和大于第三边即为答案
     */
    public static int largestPerimeter(int[] A) {
        if(A.length < 3 || A == null) return 0;
        Arrays.sort(A);
        int l = A.length;
        for(int i = l - 1; i >= 2; i--) {
            //System.out.println(A[i] +" "+A[i-1] +" "+A[i-2]);
            if(A[i] < (A[i - 1] + A[i - 2])) return A[i] + A[i-1] + A[i-2];
        }
        return 0;
    }
}
