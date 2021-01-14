package DFSs;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KuoHaoGenerate {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder cur = new StringBuilder();
		dfs(res, cur, 0, 0, n);
		return res;
	}

	/**
	 *
	 * @param res 最终结果
	 * @param cur 当前正在组合的括号
	 * @param left 左括号个数
	 * @param right 右括号个数
	 * @param max 一边括号最多个数
	 */
	public static void dfs(List<String> res, StringBuilder cur, int left, int right, int max) {
		//若总括号数等于一边*2时将当前括号组合返回
		if(cur.length() >= max * 2) {
			res.add(cur.toString());
			return;
		}

		//当左括号的小于一边最多个数时
		if(left < max) {
			cur.append('(');
			dfs(res, cur, left+1, right, max);
			//返回后剪枝
			cur.deleteCharAt(cur.length() - 1);
		}

		//右括号要比左括号少时才能加入
		if(right < left) {
			cur.append(')');
			dfs(res, cur, left, right+1, max);
			//剪枝
			cur.deleteCharAt(cur.length()-1);
		}
	}
}
