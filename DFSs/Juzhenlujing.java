package DFSs;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false

 */

/*
 * 用DFS通过递归，先往一个方向搜到底，然后若未找到正确结果则返回上一节点重新查找。
 */
public class Juzhenlujing {
	
	
	public boolean exist(char[][] board, String word) {
		//boolean res = true;
		
		char[] c = word.toCharArray();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(dfs(board, c, i, j, 0)) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	boolean dfs(char[][] board, char[] c, int i, int j, int k) {
		//若i，j超过了边界，或者当前遍历到的矩阵中的值不等于要找的，便返回false。
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != c[k]) {
			return false;
		}
		//若成功遍历到了全部的字符串的字符，返回true。
		if(k == c.length) {
			return true;
		}
		//先将遍历到的矩阵值存入temp，再赋值‘/’以标记为遍历过。
		char temp = board[i][j];
		board[i][j] = '/';
		//往下遍历，上下左右。
		boolean res = dfs(board, c, i - 1, j, k + 1) || dfs(board, c, i, j - 1, k + 1) || dfs(board, c, i + 1, j, k + 1) || dfs(board, c, i, j + 1, k + 1);
		
		//当前遍历结束后，恢复现场。
		board[i][j] = temp;
		
		
		return res;
	}

}
