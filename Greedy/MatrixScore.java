package Greedy;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MatrixScore {
    public static void main(String[] args) {
        int[][] a = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(a));
    }

    /*
    先将第一列都变为1，

     */
    public static int matrixScore(int[][] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i][0] == 0) {
                for(int j = 0; j < A[0].length; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }

        for(int j = 0; j < A[0].length; j++) {
            int count = 0;
            for(int i = 0; i < A.length; i++) {
                count = count + A[i][j];
            }
            res = res + Math.max(count, A.length - count) * (1 << (A[0].length - j - 1));
        }
        return res;
    }
}
