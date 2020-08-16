package 面试算法题;


public class HiretualTest {
	int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 为地名编码
        // {"Huilongguan": 0, "Chaoyang Park": 1, "National Stadium": 2, "Olympic Park": 3, "Tsinghua University": 4}
        int[][] dirs = new int[5][5];
        dirs[0][1] = 10;
        dirs[0][2] = 8;
        dirs[0][3] = 15;
        dirs[1][3] = 12;
        dirs[2][4] = 10;
        dirs[3][4] = 5;
        dirs[3][0] = 17;
        dirs[4][0] = 10;
 
        HiretualTest main = new HiretualTest();
        main.dfs(dirs, 0, 0);
        System.out.println(main.ans);
    }
 
    private void dfs(int[][] dirs, int i, int sum){
        if (i == 0 && sum != 0) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int j = 0; j < dirs[0].length; ++j)
            if (dirs[i][j] > 0)
                dfs(dirs, j, sum + dirs[i][j]);
    }
}
