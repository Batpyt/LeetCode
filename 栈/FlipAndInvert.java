package 栈;

import java.util.Stack;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FlipAndInvert {
    public static void main(String[] args) {
        int[][] a = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] res = flipAndInvertImage(a);
        for(int[] r : res) {
            for(int re : r) {
                System.out.print(re+"-");
            }
            System.out.println();
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        int j = 0;
        for(int[] a : A) {
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < a.length; i++) {
                if(a[i] == 0) a[i] = 1;
                else a[i] = 0;
                stack.push(a[i]);
            }
            int index = 0;
            while(!stack.isEmpty()) {
                res[j][index] = stack.pop();
                index++;
            }
            j++;
        }

        return res;
    }
}
