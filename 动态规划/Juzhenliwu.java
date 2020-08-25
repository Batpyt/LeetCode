package 动态规划;
/*
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物。
 */
/*
动态规划法，新建相同大小矩阵记录遍历到该位置的最大和。
其中带第一行和第一列中没有其他选择，直接逐个相加。
在中间的元素则对比上边和左边的大小，加上大的数。
 */

public class Juzhenliwu {
    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(maxValue(grid));
    }
    public static int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == j && j == 0) {
                    continue;
                }
                if(i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if(i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                else{
                    if(dp[i - 1][j] > dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                    else{
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}
