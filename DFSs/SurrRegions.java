package DFSs;

/**
 *
 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

 示例:

 X X X X
 X O O X
 X X O X
 X O X X
 运行你的函数后，矩阵变为：

 X X X X
 X X X X
 X X X X
 X O X X
 解释:

 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

public class SurrRegions {
	public static void main(String[] args) {
		char[][] board = {
				{'X','X','O','X'},
				{'O','X','O','O'},
				{'X','O','X','X'},
				{'X','X','X','O'}
		};
		solve(board);
		for(char[] cs : board) {
			for(char c : cs) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

	/*
	 先从四个边开始，若有O，往里dfs遍历
	 将连通的O都变成-
	 再将剩下的O变成X
	 再将-变成O
	 */
	public static void solve(char[][] board) {
		if(board == null || board.length == 0) return;

		int row = board.length;
		int col = board[0].length;

		//四个边
		for(int j = 0; j < col; j++) {
			if(board[0][j] == 'O') {
				dfs(board, 0, j);
			}
			if(board[row - 1][j] == 'O') {
				dfs(board, row - 1, j);
			}
		}

		for(int i = 0;i < row; i++) {
			if(board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if(board[i][col - 1] == 'O') {
				dfs(board, i, col - 1);
			}
		}

		//将剩下的变成X
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

		//将-变成O
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == '-') {
					board[i][j] = 'O';
				}
			}
		}

	}

	public static void dfs(char[][] board, int i, int j) {
		//若超出边界则返回
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		if(board[i][j] == 'O') {
			board[i][j] = '-';
			dfs(board, i + 1, j);
			dfs(board, i - 1, j);
			dfs(board, i , j + 1);
			dfs(board, i , j - 1);
		}

		//若下一个不是O，返回
		return;
	}
}
