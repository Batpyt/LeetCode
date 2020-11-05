package 不知名类型;

import java.util.ArrayList;
import java.util.List;

public class RingInWuxiangtu {
    /*
    0 1 1 0        0
    0 0 1 0       / \
    0 0 0 0      2---1
    0 0 0 0
     */
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{0,0,1,0},{0,0,0,0},{0,0,0,0}};

        int[][] g = turnGraph(matrix);
        for(int[] g1 : g) {
            for(int g2 : g1) {
                System.out.print(g2 + " ");
            }
            System.out.println();
        }

        System.out.println(hasLoop(g));

    }

    public static boolean hasLoop(int[][] graph) {
        List<Integer>[] route = new ArrayList[graph.length];
        for(int[] i : graph) {
            int n1 = i[0];
            int n2 = i[1];
            if(route[n1] == null) {
                route[n1] = new ArrayList<>();
            }
            if(route[n2] == null) {
                route[n2] = new ArrayList<>();
            }
            route[n1].add(n2);
            route[n2].add(n1);
        }

        boolean[] visited = new boolean[graph.length];
        int[] res = {0};
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == false) {
                dfs(route, i, -1, visited, res);
                if(res[0] == 1) return true;
            }
        }
        return res[0] == 1;
    }

    //1 2
    //0 1
    //0 2
    public static void dfs(List<Integer>[] route, int cur, int pre, boolean[] visited, int[] res) {
        visited[cur] = true;
        List<Integer> list = route[cur];
        for(Integer node : list) {
            if(visited[node] == false) {
                dfs(route, node, cur, visited, res);
            }
            else if(pre != node) {
                res[0] = 1;
            }
        }
    }

    //将邻接矩阵转换为{p，q}连接的形式
    public static int[][] turnGraph(int[][] matrix) {
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 1) l.add(new int[]{i, j});
            }
        }
        int[][] res = new int[l.size()][2];
        int index = 0;
        for(int[] i : l) {
            res[index] = l.get(index);
            index++;
        }
        return res;
    }
}
