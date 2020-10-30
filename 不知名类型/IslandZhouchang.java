package 不知名类型;

/*
给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 

示例 :

输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/island-perimeter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandZhouchang {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0},{0,1,0,0},{1,1,0,0}};

        System.out.println(islandPerimeter(grid));

    }

    public static int islandPerimeter(int[][] grid) {
        int[][] newg = new int[grid.length + 2][grid[0].length + 2];

        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        //在外层包一圈0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newg[i + 1][j + 1] = grid[i][j];
            }
        }

        for(int i = 1; i < newg.length - 1; i++) {
            for(int j = 1; j < newg[0].length - 1; j++) {
                //内层若是1去计算周长加几
                if(newg[i][j] == 1) res = res + sum(i,j,newg,n,m);
            }
        }
//        for(int[] l : newg) {
//            for(int i : l) {
//                System.out.print(i + " ");
//            }
//            System.out.println(" ");
//        }

        return res;

    }

    public static int sum(int i, int j, int[][] g, int n,int m) {
        //上下左右有一个是0的周长就加1
        int sum = 0;
        if(g[i - 1][j] == 0) sum++;
        if(g[i + 1][j] == 0) sum++;
        if(g[i][j + 1] == 0) sum++;
        if(g[i][j - 1] == 0) sum++;

        return sum;
    }
}
