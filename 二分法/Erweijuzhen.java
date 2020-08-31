package 二分法;
/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
 */
/*
二分法，先确定哪一行，再确定是否在行中存在。
 */

public class Erweijuzhen {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] m2 = {{1}};
        System.out.println(searchMatrix(m2, 2));
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
