package 二分法;
/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
二分法，先确定哪一行，再确定是否在行中存在。
 */

public class Erweijuzhen {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] m2 = {{1}};
        System.out.println(searchMatrix(m2, 2));
        System.out.println(findNumberIn2DArray(matrix, 2));
        System.out.println(findNumberIn2DArray(matrix, 3));
    }

    /*
    简单方法，从左下角往两边看可以看成二叉搜索树。
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(target > matrix[i][j]) {
                j++;
            }
            else if(target < matrix[i][j]) {
                i--;
            }
            else return true;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int u = 0;
        int b = matrix.length - 1;
        int col = matrix[0].length - 1;
        int mid = 0;
        while(u < b) {  //确定在哪一行
            mid = u + (b - u) / 2;
//            if(target == matrix[mid][0]) {
//                 break;
//            }
            if(target > matrix[mid][col]) {
                u = mid + 1;
            }
            else {
                b = mid;
            }
        }

        System.out.println(u);
        int k = u;
        int l = 0;
        int r = matrix[k].length - 1;
        while(l <= r) {  //确定是否存在
            mid = l + (r - l) / 2;
            if(target == matrix[k][mid]) return true;
            if(target < matrix[k][mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }


        return false;
    }


}
