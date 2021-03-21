package 不知名类型;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SetZeros {
    public static void main(String[] args) {
        int[][] m = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(m);
        for(int[] n : m) {
            for(int i : n) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) matrix[i][j] = -Integer.MIN_VALUE + 1;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -Integer.MIN_VALUE + 1) {
                    for(int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] != -Integer.MIN_VALUE + 1) matrix[k][j] = 0;
                    }
                    for(int k = 0; k < matrix[0].length; k++) {
                        if(matrix[i][k] != -Integer.MIN_VALUE + 1) matrix[i][k] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -Integer.MIN_VALUE + 1) matrix[i][j] = 0;
            }
        }
    }
}
