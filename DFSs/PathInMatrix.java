package DFSs;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathInMatrix {
	public static void main(String[] args) {
		char[][] board = {{'a','b'},{'c','d'}};
		String word = "abcd";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
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

	/**
	 * 回溯法
	 * @param board 矩阵
	 * @param c 字符串
	 * @param i 纵坐标
	 * @param j 横坐标
	 * @param count 已匹配的个数
	 * @return
	 */
	public static boolean dfs(char[][] board, char[] c, int i, int j, int count) {
		//若横纵坐标超出范围，或字符不匹配，返回false
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != c[count]) {
			return false;
		}
		if(count == c.length - 1) {
			return true;
		}

		//先将遍历到的元素记录，再更改，再往下递归
		char temp = board[i][j];
		board[i][j] = '/';
		boolean res = dfs(board, c, i + 1, j, count+1) || dfs(board, c, i - 1, j, count+1)
				|| dfs(board, c, i, j + 1, count+1) || dfs(board, c, i, j - 1, count+1);
		//回溯，将改的元素复原
		board[i][j] = temp;
		return res;
	}
}
