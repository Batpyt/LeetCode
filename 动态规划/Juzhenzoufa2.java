package 动态规划;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
但是矩阵中有障碍物，用1表示。
 */
/*
动态规划，新建dp[m][n]，其中，将障碍物的位置赋值为0。
需要注意，第一行和第一列有障碍物时，后面的均为0。
在计算dp矩阵时，遇到0则不计算。
 */

public class Juzhenzoufa2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,1,0,0},{1,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++) {  //初始化dp矩阵，障碍物赋值0。
            for(int j = 0; j < n; j++) {
                System.out.print(obstacleGrid[i][j]);
                if(obstacleGrid[i][j] == 1) matrix[i][j] = 0;
                else matrix[i][j] = 1;
            }
            System.out.println();
        }
        for(int i = 1; i < m; i++) {  //判断第一列有没有障碍物
            if(obstacleGrid[i][0] == 1 || matrix[i - 1][0] == 0) matrix[i][0] = 0;
            else matrix[i][0] = 1;
            //System.out.println(matrix[i][0]);
        }
        for(int j = 1; j < n; j++) {  //判断第一列
            if(obstacleGrid[0][j] == 1 || matrix[0][j - 1] == 0) matrix[0][j] = 0;
            else matrix[0][j] = 1;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


        for(int i = 1; i < m; i++) {  //计算dp矩阵
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] != 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                    //System.out.println(matrix[i][j] + " "+i+" "+j);
                }
            }
        }

        return matrix[m - 1][n - 1];
    }


}
