package 动态规划;
/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
/*
动态规划，每次加上面或右边较小的那一个。
 */
public class Zuixiaolujing {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(i == 0 && j > 0) grid[i][j] = grid[i][j] + grid[i][j - 1];  //第一行
                if(i > 0 && j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];  //第一列
                if(i >0 && j > 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);  //每次加右边或上边较小的那一个
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
