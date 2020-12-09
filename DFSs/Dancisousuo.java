package DFSs;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */
/*
使用dfs，找到第一个与首字符相同的元素便开始遍历
分四个方向分别遍历，若该方向新遍历到的元素在board范围内，且与下一个字符相同，且还没用过，则继续遍历，否则回溯
 */
public class Dancisousuo {
    //char[][] board;
//    int m;
//    int n;
    //int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        char[][] board = new char[3][4];

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};  //四个方向
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {  //与首个字符相同的元素
                    if(dfs(i,j,m,n,board,visited,word,dirs,0)) return true;  //递归遍历
                }
            }
        }
        return false;
    }

    public static boolean dfs(int x, int y, int m, int n, char[][] board, boolean[][] visited, String word, int[][] dirs, int i) {
        if(i == word.length() - 1) return true;  //匹配到完整字符串，返回true

        visited[x][y] = true;  //当前元素标记为使用过
        for(int[] dir : dirs) {  //四个不同方向
            int newx = x + dir[0];
            int newy = y + dir[1];
            //新的元素在board范围内，且此次递归没有遍历过，且与下一个元素相同，则继续递归
            if(newx >= 0 && newx < m && newy >=0 && newy < n && word.charAt(i + 1) == board[newx][newy] && !visited[newx][newy]) {
                if(dfs(newx, newy,m,n,board,visited,word,dirs, i+1)) return true;  //继续递归
            }
        }

        visited[x][y] = false;  //回溯，将元素改回未标记
        return false;
    }
}
