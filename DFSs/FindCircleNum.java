package DFSs;

/**
 *
 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

 返回矩阵中 省份 的数量。



 示例 1：
 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 输出：2
 */

public class FindCircleNum {
    public static void main(String[ ]args) {
        int[][] c = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(c));
    }

    /*
    当访问到一个为访问过的城市，深度搜索所有与它相连的城市
     */
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            //遍历到一个未访问过的城市
            if (!visited[i]) {
                //深度搜索与其相连的城市
                dfs(visited, isConnected, i);
                count++;
            }
        }
        return count;
    }

    //深度搜索
    public static void dfs(boolean[] visited, int[][] isConnected, int i) {
        for(int j = 0; j < isConnected[i].length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                //继续搜索
                dfs(visited, isConnected, j);
            }
        }
    }
}
