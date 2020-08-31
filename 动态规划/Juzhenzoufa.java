package 动态规划;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 */
/*
矩阵右下移动问题，动态规划。新建dp[n][m]矩阵，记录到目前位置的可能方法。
第一行和第一列均为1，只有一中=种方法。
之后的每个位置的方法个数为上一格和右边一格的可能方法树的和。
 */

public class Juzhenzoufa {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {  //第一列为1
            dp[i][0] = 1;
        }
        for(int j = 0; j < m; j++) {  //第一行为1
            dp[0][j] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                //System.out.println(dp[i][j]);
            }
        }

        return dp[n - 1][m - 1];
    }
}
