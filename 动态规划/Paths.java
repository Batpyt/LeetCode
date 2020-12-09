package 动态规划;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Paths {
    public static void main(String[] args) {
        int[][] m = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePaths2(m));
    }

    /*
    维护dp数组，每个位置的值代表走到该位置的路径个数
    先将障碍物所在位置在dp数组中赋值0，代表从这个位置开始的路径是0个
    若顶端边或左边有障碍物，该边后面都设为0
     */
    public static int uniquePaths2(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //障碍物位置的路径个数为0
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = 1;
            }
        }

        //两条边若有障碍物，路径都是0
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) dp[i][0] = 0;
            else dp[i][0] = 1;
        }

        for(int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) dp[0][j] = 0;
            else dp[0][j] = 1;
        }

        //常规操作
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(dp[i][j] != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
