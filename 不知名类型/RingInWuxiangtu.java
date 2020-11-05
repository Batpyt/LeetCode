package 不知名类型;

import java.util.ArrayList;
import java.util.List;
/*
判断邻接矩阵表示的无向图中有无环
https://blog.csdn.net/weixin_43312097/article/details/105317541
 */

public class RingInWuxiangtu {
    /*
    0 1 1 0        0
    0 0 1 0       / \
    0 0 0 0      2---1
    0 0 0 0
     */
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{0,0,1,0},{0,0,0,0},{0,0,0,0}};
        int size = matrix.length;

        int[][] g = turnGraph(matrix);
        for(int[] g1 : g) {
            for(int g2 : g1) {
                System.out.print(g2 + " ");
            }
            System.out.println();
        }

        System.out.println(hasLoop(g, size));

    }

    public static boolean hasLoop(int[][] graph, int size) {
        //新建列表数组来储存每个点的路径
        //路径例子：0-1，0-2//1-2。。。
        List<Integer>[] route = new ArrayList[size];
        for(int[] i : graph) {
            int n1 = i[0];
            int n2 = i[1];

            //若还没有这个点的路径，先新建
            if(route[n1] == null) {
                route[n1] = new ArrayList<>();
            }
            if(route[n2] == null) {
                route[n2] = new ArrayList<>();
            }

            //记录路径
            route[n1].add(n2);
            route[n2].add(n1);
        }

        //记录当前点的路径是否遍历过
        boolean[] visited = new boolean[size];
        //若有环，该数组赋值为1
        int[] res = {0};
        //从0的路径开始递归
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == false) {
                dfs(route, i, -1, visited, res);
                //当结果数组为1返回true
                if(res[0] == 1) return true;
            }
        }
        return res[0] == 1;
    }

    /*
    深度遍历，传入参数为：路径链表数组，当前路径的主人，当前主人的上一个主人（也就是谁指向了现在的），遍历历史，结果。
     */
    public static void dfs(List<Integer>[] route, int cur, int pre, boolean[] visited, int[] res) {
        //设为遍历过
        visited[cur] = true;

        //获取当前路径
        List<Integer> list = route[cur];

        //开始遍历该路径中指向的节点
        for(Integer node : list) {
            //若指向的节点没被遍历过
            if(visited[node] == false) {
                //当前路径主人节点当作pre，以指向的节点为主人递归
                dfs(route, node, cur, visited, res);
            }
            //若遍历到的指向的节点已经被访问过但不是当前主人的前任，说明已经遍历过，说明有环
            else if(pre != node) {
                //结果数组设为1
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
